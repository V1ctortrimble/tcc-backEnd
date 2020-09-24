package com.unicesumar.ads.tcc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"visualization of Home"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
public class HomeController {

    public static final String PROTECTED = "{\n  \"message\": \"Usuário Protected !!\"\n}";
    public static final String ADMIN = "{\n  \"message\": \"Usuário Admin !!\"\n}";
    public static final String NOT = "{\n  \"message\": \"Usuário Não Autenticado !!\"\n}";

    @ApiOperation(value = "Returns one Body test Protected")
    @GetMapping(path = "protected/home")
    public ResponseEntity<?> getHelloprotected() {
        return new ResponseEntity<>(PROTECTED, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns one Body test Admin")
    @GetMapping(path = "admin/home")
    public ResponseEntity<?> getHelloAdmin() {
        return new ResponseEntity<>(ADMIN, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns one Body test not Authori")
    @GetMapping(path = "home")
    public ResponseEntity<?> getHello() {
        return new ResponseEntity<>(NOT, HttpStatus.OK);
    }

}
