package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.person.PersonCompanyEntityConverter;
import com.unicesumar.ads.tcc.converter.person.PersonIndividualEntityConverter;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.dto.personDTO.PersonCompanyDTO;
import com.unicesumar.ads.tcc.dto.personDTO.PersonIndividualDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"visualization of Persons"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
public class PersonController {

    public static final String PESSOA_JA_CADASTRADA = "Pessoa já cadastrada";
    private final PersonIndividualEntityConverter personIndividualEntityConverter;
    private final PersonCompanyEntityConverter personCompanyEntityConverter;
    private final PersonService personService;


    @ApiOperation(value = "Returns All persons", authorizations = { @Authorization(value="jwtToken") })
    @GetMapping(path = "/persons")
    public ResponseEntity<List<PersonIndividualDTO>> getPersons() {
        List<PersonEntity> entities = personService.getPerson();
        List<PersonIndividualDTO> dtos = personIndividualEntityConverter.toDTOList(entities);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @ApiOperation(value = "URL to add persons Individual", authorizations = { @Authorization(value="jwtToken") })
    @PostMapping(path = "/persons/individual")
    public ResponseEntity<?> postPersonIndividual(@Validated @RequestBody PersonIndividualDTO dto) {
        PersonEntity entity = personService.getPersonByCpf(dto.getIndividual().getCpf());
        if (entity == null) {
            if (dto.getActive() == null) {
                dto.setActive(true);
            }
            personService.postUsers(personIndividualEntityConverter.toEntity(dto));
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
        throw new HttpBadRequestException(PESSOA_JA_CADASTRADA);
    }

    @ApiOperation(value = "URL to add persons Company", authorizations = { @Authorization(value="jwtToken") })
    @PostMapping(path = "/persons/company")
    public ResponseEntity<?> postPersonCompany(@Validated @RequestBody PersonCompanyDTO dto) {
        PersonEntity entity = personService.getPersonByCpf(dto.getCompany().getCnpj());
        if (entity == null) {
            if (dto.getActive() == null) {
                dto.setActive(true);
            }
            personService.postUsers(personCompanyEntityConverter.toEntity(dto));
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
        throw new HttpBadRequestException(PESSOA_JA_CADASTRADA);
    }
}
