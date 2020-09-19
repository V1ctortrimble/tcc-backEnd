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
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class HomeController {

    public static final String RETURN_TEST_JSON = "{\n  \"message\": \"Hello Body Home!\"\n}";

    @ApiOperation(value = "Returns one Body test")
    @GetMapping(value = "/home")
    public ResponseEntity<?> getHello() {
        return new ResponseEntity<>(RETURN_TEST_JSON, HttpStatus.OK);
    }

}
