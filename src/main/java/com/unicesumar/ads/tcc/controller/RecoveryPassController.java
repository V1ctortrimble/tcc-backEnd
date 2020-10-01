package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.UsersEntityConverter;
import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.dto.UsersDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import com.unicesumar.ads.tcc.service.RecoveryPassService;
import com.unicesumar.ads.tcc.service.UsersService;
import com.unicesumar.ads.tcc.util.PasswordEncoderUtil;
import com.unicesumar.ads.tcc.util.ValidatePasswordUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"visualization of Recovery Pass"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
public class RecoveryPassController {

    /**
     * Constants
     */
    public static final String SENHAS_INFORMADAS_NAO_CONFEREM = "Senhas Informadas não conferem";
    public static final String USUARIO_NAO_LOCALIZADO_PARA_ALTERAR_SENHA = "Usuário não localizado para alterar senha";
    public static final String SENHA_NAO_ATENDE_OS_REQUISITOS = "senha não atende os requisitos";
    public static final String CODIGO_EXPIRADO_OU_INEXISTENTE = "Código expirado ou inexistente";

    /**
     * Services
     */
    private final UsersService usersService;
    private final RecoveryPassService recoveryPassService;

    /**
     * Converters
     */
    private final UsersEntityConverter usersEntityConverter;

    /**
     * Utils
     */
    private final PasswordEncoderUtil passwordEncoder;
    private final ValidatePasswordUtil validatePassword;

    @ApiOperation(value = "Recovers user to change password")
    @GetMapping(path = "recoverysenha/{code}")
    public ResponseEntity<UsersDTO> getCodeRecoveryPass(@PathVariable("code") String code) {
        UsersEntity entity = usersService.getUserChangePass(code);

        if (entity != null){
            UsersDTO dto = usersEntityConverter.toDTO(entity);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }else {
            throw new HttpNotFoundException(CODIGO_EXPIRADO_OU_INEXISTENTE);
        }
    }

    @ApiOperation(value = "URL to change user password")
    @PutMapping(path = "changepassword")
    public ResponseEntity<UsersDTO> putPassword(@Validated @RequestBody UsersDTO dto) {

        UsersEntity entity = usersService.getUserByLogin(dto.getUsername());

        if (entity != null) {
            if (dto.getPassword().equals(dto.getRepeatPassword())) {
                if (validatePassword.getMatcher(dto.getPassword())) {
                    entity.setPassword(passwordEncoder.encodePassword(dto.getPassword()));
                    usersService.postUsers(entity);
                    //TODO: Criar uma mensagem de retorno HttpStatus.OK
                    return new ResponseEntity<>(HttpStatus.OK);
                }
                throw new HttpBadRequestException(SENHA_NAO_ATENDE_OS_REQUISITOS);
            }
            throw new HttpBadRequestException(SENHAS_INFORMADAS_NAO_CONFEREM);
        }
        throw new HttpNotFoundException(USUARIO_NAO_LOCALIZADO_PARA_ALTERAR_SENHA);
    }

    @ApiOperation(value = "Send password recovery email")
    @PostMapping(path = "sendemail")
    public ResponseEntity<?> getHelloAdmin(@Validated @RequestBody UsersDTO dto) {
        recoveryPassService.recoveryPass(dto.getUsername());
        //TODO: Criar uma mensagem de retorno HttpStatus.OK
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
