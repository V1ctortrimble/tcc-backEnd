package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.UsersEntityConverter;
import com.unicesumar.ads.tcc.converter.UsersEntityPostConverter;
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

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.*;

@Api(tags = {"visualization of Recovery Pass"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
public class RecoveryPassController {

    /**
     * Services
     */
    private final UsersService usersService;
    private final RecoveryPassService recoveryPassService;

    /**
     * Converters
     */
    private final UsersEntityConverter usersEntityConverter;
    private final UsersEntityPostConverter usersEntityPostConverter;
    /**
     * Utils
     */
    private final PasswordEncoderUtil passwordEncoder;
    private final ValidatePasswordUtil validatePassword;


    /**
     * GetsMapping
     */
    @ApiOperation(value = "URL to recovers user to change password")
    @GetMapping(path = "/recoverypassword/{code}")
    public ResponseEntity<UsersDTO> getCodeRecoveryPass(@PathVariable("code") String code) {
        UsersEntity entity = usersService.getUserChangePass(code);

        if (entity != null){
            entity.setPassword(null);
            UsersDTO dto = usersEntityConverter.toDTO(entity);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpNotFoundException(CODIGO_EXPIRADO_OU_INEXISTENTE);
    }

    /**
     * PostsMapping
     */
    @ApiOperation(value = "URL to send password recovery email")
    @PostMapping(path = "/sendemail")
    public ResponseEntity<?> sendRecoveryEmail(@Validated @RequestBody UsersDTO dto) {
        try {
            recoveryPassService.recoveryPass(dto.getUsername());
            return new ResponseEntity<>(EMAIL_ENVIADO_COM_SUCESSO, HttpStatus.OK);
        }
        catch (Exception e){
            throw new HttpBadRequestException(e.getMessage());
        }
    }

    /**
     * PutsMapping
     */
    @ApiOperation(value = "URL to change user password")
    @PutMapping(path = "/changepassword")
    public ResponseEntity<?> putPassword(@Validated @RequestBody UsersDTO dto) {

        UsersEntity entity = usersService.getUserByUsername(dto.getUsername());

        if (entity != null) {
            if (dto.getPassword().equals(dto.getRepeatPassword())) {
                if (validatePassword.getMatcher(dto.getPassword())) {
                    entity.setPassword(passwordEncoder.encodePassword(dto.getPassword()));
                    entity.setCode(null);
                    usersService.postUsers(usersEntityPostConverter.toDTO(entity));
                    return new ResponseEntity<>(SENHA_ALTERADA_COM_SUCESSO, HttpStatus.OK);
                }
                throw new HttpBadRequestException(SENHA_NAO_ATENDE_OS_REQUISITOS);
            }
            throw new HttpBadRequestException(SENHAS_INFORMADAS_NAO_CONFEREM);
        }
        throw new HttpNotFoundException(USUARIO_NAO_LOCALIZADO_PARA_ALTERAR_SENHA);
    }
}
