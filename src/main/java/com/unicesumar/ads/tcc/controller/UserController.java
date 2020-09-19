package com.unicesumar.ads.tcc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"visualization of users"})
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class UserController {

    public static final String RETURN_TEST_JSON = "{\"users\":[{\"name\":\"Lucas\", \"country\":\"Brazil\"}," +
            "{\"name\":\"Jackie\",\"country\":\"China\"}]}";

    @ApiOperation(value = "Returns one Body test", authorizations = { @Authorization(value="jwtToken") })
    @GetMapping(value = "/users")
    public ResponseEntity<?> getUsers() {
        return new ResponseEntity<>(RETURN_TEST_JSON, HttpStatus.OK) ;
    }

}
