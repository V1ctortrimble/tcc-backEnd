package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.dto.UsersDTO;
import com.unicesumar.ads.tcc.dto.usersPostDTO.UsersPostDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import com.unicesumar.ads.tcc.service.UsersService;
import com.unicesumar.ads.tcc.util.PaginatorUtil;
import com.unicesumar.ads.tcc.util.PasswordEncoderUtil;
import com.unicesumar.ads.tcc.util.ValidatePasswordUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.*;

@Api(tags = {"visualization of Users"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class UsersController {

    /**
     * Services
     */
    private final UsersService usersService;

    /**
     * Utils
     */
    private final PasswordEncoderUtil passwordEncoder;
    private final ValidatePasswordUtil validatePassword;
    private final PaginatorUtil paginator;


    /**
     * GetsMapping
     */
    @ApiOperation(value = "URL to returns user by Username, name, fist name, CPF, or return all users"
            , authorizations = { @Authorization(value="jwtToken") })
    @GetMapping(path = "/users/filter")
    public ResponseEntity<Page<UsersDTO>> getUsersAllAndFilter(Pageable pageable,
                                                               @RequestParam(value = "cpf",
                                                                       required = false)
                                                                       Optional<String> cpf,
                                                               @RequestParam(value = "username",
                                                                       required = false)
                                                                           Optional<String> username,
                                                               @RequestParam(value = "name",
                                                                       required = false)
                                                                           Optional<String> name,
                                                               @RequestParam(value = "lastname",
                                                                       required = false)
                                                                           Optional<String> lastName,
                                                               @RequestParam(value = "active",
                                                                       defaultValue = "true",
                                                                       required = false) Boolean active) {
        Page<UsersDTO> dtos = paginator.convertDTOUserToPages(username, name, lastName,
                cpf, active, pageable);
        for (UsersDTO dto : dtos) { dto.setPassword(null); }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @ApiOperation(value = "URL to returns users registered according to Username",
            authorizations = { @Authorization(value="jwtToken") })
    @GetMapping(value = "/user")
    public ResponseEntity<UsersDTO> getUsersByUsername(@RequestParam(value = "username") String username) {
        UsersDTO dto = usersService.getUserByUsernameBuildContact(username);
        if (dto != null) {
            dto.setPassword(null);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpNotFoundException(USUARIO_NAO_LOCALIZADO);
    }

    /**
     * PotsMapping
     */
    @ApiOperation(value = "URL to add users", authorizations = { @Authorization(value="jwtToken") })
    @PostMapping(path = "/user")
    public ResponseEntity<UsersPostDTO> postUsers(@Validated @RequestBody UsersPostDTO dto) {
        UsersEntity entity = usersService.getUserByUsername(dto.getUsername());
        if (entity == null) {
            if (dto.getPassword().equals(dto.getRepeatPassword())) {
                if (validatePassword.getMatcher(dto.getPassword())) {
                    dto.setPassword(passwordEncoder.encodePassword(dto.getPassword()));
                    if (dto.getActive() == null) {
                        dto.setActive(true);
                    }
                    usersService.postUsers(dto);
                    return new ResponseEntity<>(dto, HttpStatus.CREATED);
                }
                throw new HttpBadRequestException(SENHA_NAO_ATENDE_OS_REQUISITOS);
            }
            throw new HttpBadRequestException(SENHAS_INFORMADAS_NAO_CONFEREM);
        }
        throw new HttpBadRequestException(USUARIO_JA_CADASTRADO);
    }

    /**
     * PutsMapping
     */
    @ApiOperation(value = "URL to update users", authorizations = { @Authorization(value="jwtToken") })
    @PutMapping(path = "/user")
    public ResponseEntity<UsersDTO> putUsers(@RequestParam(value = "username") String username,
                                      @Validated @RequestBody UsersDTO dto) {
        UsersEntity entity = usersService.getUserByUsername(username);
        if (entity != null) {
           usersService.putUsers(dto);
           UsersDTO dto2 = usersService.getUserByUsernameBuildContact(username);
           return new ResponseEntity<>(dto2, HttpStatus.OK);
        }
        throw new HttpNotFoundException(USUARIO_NAO_LOCALIZADO_PARA_ALTERAR);
    }
}
