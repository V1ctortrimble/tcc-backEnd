package com.unicesumar.ads.tcc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"visualization tests of Roles"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
public class RolesController {

    public static final String PROTECTED = "{\n  \"message\": \"User Protected !!\"\n}";
    public static final String ADMIN = "{\n  \"message\": \"User Admin !!\"\n}";

    @ApiOperation(value = "Test Admin", authorizations = { @Authorization(value="jwtToken") })
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "teste/admin")
    public ResponseEntity<?> getHelloAdmin() {
        return new ResponseEntity<>(ADMIN, HttpStatus.OK);
    }

    @ApiOperation(value = "Test Protected", authorizations = { @Authorization(value="jwtToken") })
    @PreAuthorize("hasRole('USER')")
    @GetMapping(path = "teste/protected")
    public ResponseEntity<?> getHelloprotected() {
        return new ResponseEntity<>(PROTECTED, HttpStatus.OK);
    }

}
