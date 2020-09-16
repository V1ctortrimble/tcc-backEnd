package com.unicesumar.ads.tcc.controllers;

import com.unicesumar.ads.tcc.converter.PersonEntityConverter;
import com.unicesumar.ads.tcc.dto.PersonDTO;
import com.unicesumar.ads.tcc.entity.PersonEntity;
import com.unicesumar.ads.tcc.repository.PersonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"Directory for visualization of people"})
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class PersonController {

    private final PersonEntityConverter converter;
    private final PersonRepository repository;

    @ApiOperation("Returns all registered person")
    @GetMapping(value = "/pessoas")
    public ResponseEntity<List<PersonDTO>> getPersons() {
        try {
            List<PersonEntity> entities = repository.findAll();
            List<PersonDTO> dtos = converter.toDTOList(entities);
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
