package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.BankDetailsEntityConverter;
import com.unicesumar.ads.tcc.converter.CompanyEntityConverter;
import com.unicesumar.ads.tcc.converter.IndividualEntityConverter;
import com.unicesumar.ads.tcc.converter.person.PersonCompanyEntityConverter;
import com.unicesumar.ads.tcc.converter.person.PersonGetEntityConverter;
import com.unicesumar.ads.tcc.converter.person.PersonIndividualEntityConverter;
import com.unicesumar.ads.tcc.data.entity.BankDetailsEntity;
import com.unicesumar.ads.tcc.data.entity.CompanyEntity;
import com.unicesumar.ads.tcc.data.entity.IndividualEntity;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.dto.CompanyDTO;
import com.unicesumar.ads.tcc.dto.IndividualDTO;
import com.unicesumar.ads.tcc.dto.personDTO.PersonBankDetailsDTO;
import com.unicesumar.ads.tcc.dto.personDTO.PersonCompanyDTO;
import com.unicesumar.ads.tcc.dto.personDTO.PersonIndividualDTO;
import com.unicesumar.ads.tcc.dto.personGetDTO.PersonGetDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import com.unicesumar.ads.tcc.service.BankDetailsService;
import com.unicesumar.ads.tcc.service.CompanyService;
import com.unicesumar.ads.tcc.service.IndividualService;
import com.unicesumar.ads.tcc.service.PersonService;
import com.unicesumar.ads.tcc.util.PaginatorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.*;

@Api(tags = {"visualization of Persons"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
public class PersonController {

    /**
     * Services
     */
    private final PersonService personService;
    private final IndividualService individualService;
    private final CompanyService companyService;
    private final BankDetailsService bankDetailsService;

    /**
     * Converters
     */
    private final PersonIndividualEntityConverter personIndividualEntityConverter;
    private final PersonCompanyEntityConverter personCompanyEntityConverter;
    private final BankDetailsEntityConverter bankDetailsEntityConverter;
    private final PersonGetEntityConverter personGetEntityConverter;
    private final IndividualEntityConverter individualEntityConverter;
    private final CompanyEntityConverter companyEntityConverter;

    /**
     * Utils
     */
    private final PaginatorUtil paginator;


    @ApiOperation(value = "Returns All persons", authorizations = { @Authorization(value="jwtToken") })
    @GetMapping(path = "/persons/individual/all")
    public ResponseEntity<Page<IndividualDTO>> getPersonsIndividual(Pageable pageable) {
        List<IndividualEntity> entities = individualService.getIndividuals();
        List<IndividualDTO> dtos = individualEntityConverter.toDTOList(entities);
        Page<IndividualDTO> pages = paginator.paginateIndividualDTO(pageable, dtos);
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns All persons", authorizations = { @Authorization(value="jwtToken") })
    @GetMapping(path = "/persons/company/all")
    public ResponseEntity<Page<CompanyDTO>> getPersonsCompany(Pageable pageable) {
        List<CompanyEntity> entities = companyService.getCompanies();
        List<CompanyDTO> dtos = companyEntityConverter.toDTOList(entities);
        Page<CompanyDTO> pages = paginator.paginateCompanyDTO(pageable, dtos);
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @ApiOperation(value = "URL to add persons Individual", authorizations = { @Authorization(value="jwtToken") })
    @PostMapping(path = "/persons/individual")
    public ResponseEntity<?> postPersonIndividual(@Validated @RequestBody PersonIndividualDTO dto) {
        PersonEntity entityCpg = personService.getPersonByCpf(dto.getIndividual().getCpf());
        PersonEntity entityRg = personService.getPersonByRg(dto.getIndividual().getRg());
        if (entityCpg == null && entityRg == null) {
            if (dto.getActive() == null) {
                dto.setActive(true);
            }
            personService.postUsers(personIndividualEntityConverter.toEntity(dto));
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
        throw new HttpBadRequestException(PESSOA_JA_CADASTRADA);
    }

    @ApiOperation(value = "URL to add persons Company")
    @PostMapping(path = "/persons/company")
    public ResponseEntity<?> postPersonCompany(@Validated @RequestBody PersonCompanyDTO dto) {
        PersonEntity entity = personService.getPersonByCnpj(dto.getCompany().getCnpj());
        if (entity == null) {
            if (dto.getActive() == null) {
                dto.setActive(true);
            }
            personService.postUsers(personCompanyEntityConverter.toEntity(dto));
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
        throw new HttpBadRequestException(PESSOA_JA_CADASTRADA);
    }

    @ApiOperation(value = "URL to add persons Company")
    @PostMapping(path = "/persons/bankDetails")
    public ResponseEntity<?> postBankDetails(@Validated @RequestBody PersonBankDetailsDTO dto) {

        PersonEntity entity;
        if (dto.getDocument().length() == 11){
            entity = personService.getPersonByCpf(dto.getDocument());
        }
        else if (dto.getDocument().length() == 14){
            entity = personService.getPersonByCnpj(dto.getDocument());
        }
        else {
            throw new HttpBadRequestException(DOCUMENTO_INVALIDO);
        }

        if (entity != null) {
            BankDetailsEntity bank = bankDetailsEntityConverter.toEntity(dto.getBanksDetails());
            bank.setPerson(entity);
            bankDetailsService.postBankDetails(bank);

            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
        throw new HttpNotFoundException(PESSOA_NAO_CADASTRADA);
    }

    @ApiOperation(value = "Return person by cpf")
    @GetMapping(path = "/persons/individual")
    public ResponseEntity<PersonGetDTO> getPersonIndividual(@RequestParam(value = "cpf") String cpf) {
        PersonEntity entity = personService.getPersonByCpf(cpf);
        PersonGetDTO dto = personGetEntityConverter.toDTO(entity);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
