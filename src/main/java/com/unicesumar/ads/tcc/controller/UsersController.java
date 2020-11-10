package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.UsersEntityConverter;
import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.dto.UsersDTO;
import com.unicesumar.ads.tcc.dto.usersPostDTO.UsersPostDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import com.unicesumar.ads.tcc.service.UsersService;
import com.unicesumar.ads.tcc.util.PasswordEncoderUtil;
import com.unicesumar.ads.tcc.util.ValidatePasswordUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.*;

@Api(tags = {"visualization of Users"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('ADMIN')")
public class UsersController {

    /**
     * Services
     */
    private final UsersService usersService;

    /**
     * Converters
     */
    private final UsersEntityConverter usersEntityConverter;

    /**
     * Utils
     */
    private final PasswordEncoderUtil passwordEncoder;
    private final ValidatePasswordUtil validatePassword;


    @ApiOperation(value = "Returns All users", authorizations = { @Authorization(value="jwtToken") })
    @GetMapping(path = "/users/all")
    public ResponseEntity<List<UsersDTO>> getUsers() {
        List<UsersDTO> dtos = usersService.getUsers();
        for (UsersDTO dto : dtos) { dto.setPassword(null); }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns users registered according to Username",
            authorizations = { @Authorization(value="jwtToken") })
    @GetMapping(value = "/user")
    public ResponseEntity<UsersDTO> getUsersByUsername(@RequestParam(value = "username") String username) {
        UsersDTO dto = usersService.getUserByUserName(username);
        if (dto != null) {
            dto.setPassword(null);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpNotFoundException(USUARIO_NAO_LOCALIZADO);
    }

    @ApiOperation(value = "URL to add users", authorizations = { @Authorization(value="jwtToken") })
    @PostMapping(path = "/user")
    public ResponseEntity<?> postUsers(@Validated @RequestBody UsersPostDTO dto) {
        UsersEntity entity = usersService.getUserByLogin(dto.getUsername());
        if (entity == null) {
            if (dto.getPassword().equals(dto.getRepeatPassword())) {
                if (validatePassword.getMatcher(dto.getPassword())) {
                    dto.setPassword(passwordEncoder.encodePassword(dto.getPassword()));
                    usersService.postUsers(dto);
                    return new ResponseEntity<>(dto, HttpStatus.CREATED);
                }
                throw new HttpBadRequestException(SENHA_NAO_ATENDE_OS_REQUISITOS);
            }
            throw new HttpBadRequestException(SENHAS_INFORMADAS_NAO_CONFEREM);
        }
        throw new HttpBadRequestException(USUARIO_JA_CADASTRADO);
    }

    //TODO: Refatorar Metodo
    @ApiOperation(value = "URL to update users", authorizations = { @Authorization(value="jwtToken") })
    @PutMapping(path = "/user")
    public ResponseEntity<?> putUsers(@RequestParam(value = "username") String username,
                                      @Validated @RequestBody UsersDTO dto) {
        UsersEntity entity = usersService.getUserByLogin(username);
        if (entity != null) {
           usersService.putUsers(dto);
           return new ResponseEntity<>(getUsersByUsername(username), HttpStatus.OK);
        }
        throw new HttpNotFoundException(USUARIO_NAO_LOCALIZADO_PARA_ALTERAR);
    }
}
