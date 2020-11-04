package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.BankDetailsEntityConverter;
import com.unicesumar.ads.tcc.converter.person.PersonCompanyEntityConverter;
import com.unicesumar.ads.tcc.converter.person.PersonCompanyGetEntityConverter;
import com.unicesumar.ads.tcc.converter.person.PersonIndividualEntityConverter;
import com.unicesumar.ads.tcc.converter.person.PersonIndividualGetEntityConverter;
import com.unicesumar.ads.tcc.data.entity.BankDetailsEntity;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.dto.BankDetailsDTO;
import com.unicesumar.ads.tcc.dto.IndividualDTO;
import com.unicesumar.ads.tcc.dto.personDTO.PersonBankDetailsDTO;
import com.unicesumar.ads.tcc.dto.personDTO.PersonCompanyDTO;
import com.unicesumar.ads.tcc.dto.personDTO.PersonIndividualDTO;
import com.unicesumar.ads.tcc.dto.personGetDTO.PersonCompanyGetDTO;
import com.unicesumar.ads.tcc.dto.personGetDTO.PersonIndividualGetDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import com.unicesumar.ads.tcc.service.BankDetailsService;
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
import java.util.Optional;

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
    private final BankDetailsService bankDetailsService;

    /**
     * Converters
     */
    private final PersonIndividualEntityConverter personIndividualEntityConverter;
    private final PersonCompanyEntityConverter personCompanyEntityConverter;
    private final BankDetailsEntityConverter bankDetailsEntityConverter;
    private final PersonIndividualGetEntityConverter personIndividualGetEntityConverter;
    private final PersonCompanyGetEntityConverter personCompanyGetEntityConverter;

    /**
     * Utils
     */
    private final PaginatorUtil paginator;

    //TODO: vai virar Filter
//    @ApiOperation(value = "Returns company by cnpj, fantasy name, social reason, state regis  or return all companies",
//            authorizations = { @Authorization(value="jwtToken")})
//    @GetMapping(path = "/persons/company/all")
//    public ResponseEntity<Page<CompanyDTO>> getPersonsCompany(Pageable pageable) {
//        Page<CompanyEntity> entities = companyService.getCompanies(pageable);
//        List<CompanyEntity> companyEntities = new ArrayList<>(entities.toList());
//        List<CompanyDTO> dtos = companyEntityConverter.toDTOList(companyEntities);
//        return new ResponseEntity<>(pages, HttpStatus.OK);
//    }

    @ApiOperation(value = "Return individual by cpf, name, last name, rg or return all individuals",
            authorizations = { @Authorization(value="jwtToken")})
    @GetMapping(path = "/persons/individual/filter")
    public ResponseEntity<Page<IndividualDTO>> getPersonIndividualAllAndFilter(Pageable pageable,
                                                                               @RequestParam(value = "cpf",
                                                                                       required = false)
                                                                                       Optional<String> cpf,
                                                                               @RequestParam(value = "rg",
                                                                                       required = false)
                                                                                       Optional<String> rg,
                                                                               @RequestParam(value = "name",
                                                                                       required = false)
                                                                                       Optional<String> name,
                                                                               @RequestParam(value = "lastname",
                                                                                       required = false)
                                                                                       Optional<String> lastName) {
        Page<IndividualDTO> dtos = paginator.convertDTOIndividualToPages(cpf, rg, name, lastName, pageable);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @ApiOperation(value = "Return person by cpf", authorizations = { @Authorization(value="jwtToken")})
    @GetMapping(path = "/persons/individual")
    public ResponseEntity<PersonIndividualGetDTO> getPersonIndividual(@RequestParam(value = "cpf") String cpf) {
        PersonEntity entity = personService.getPersonByCpf(cpf);
        PersonIndividualGetDTO dto = personIndividualGetEntityConverter.toDTO(entity);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ApiOperation(value = "Return person by cnpj", authorizations = { @Authorization(value="jwtToken")})
    @GetMapping(path = "/persons/company")
    public ResponseEntity<PersonCompanyGetDTO> getPersonCompany(@RequestParam(value = "cnpj") String cnpj) {
        PersonEntity entity = personService.getPersonByCnpj(cnpj);
        PersonCompanyGetDTO dto = personCompanyGetEntityConverter.toDTO(entity);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ApiOperation(value = "URL to add persons Individual", authorizations = { @Authorization(value="jwtToken") })
    @PostMapping(path = "/persons/individual")
    public ResponseEntity<PersonIndividualDTO> postPersonIndividual(@Validated @RequestBody PersonIndividualDTO dto) {
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

    @ApiOperation(value = "URL to add persons Company", authorizations = { @Authorization(value="jwtToken")})
    @PostMapping(path = "/persons/company")
    public ResponseEntity<PersonCompanyDTO> postPersonCompany(@Validated @RequestBody PersonCompanyDTO dto) {
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

    @ApiOperation(value = "URL to update persons individual", authorizations =  { @Authorization(value="jwtToken") })
    @PutMapping(path = "/persons/individual")
    public ResponseEntity<PersonIndividualDTO> putPersonIndividual(@RequestParam(value = "cpf") String cpf,
                                                                   @Validated @RequestBody PersonIndividualDTO dto) {
        PersonEntity entity = personService.getPersonByCpf(cpf);
        if (entity != null){
            personService.putPerson(entity, dto);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpNotFoundException(USUARIO_NAO_LOCALIZADO);
    }

    @ApiOperation(value = "URL to get Bank Details by document")
    @GetMapping(path = "/persons/bankDetails")
    public ResponseEntity<List<BankDetailsDTO>> getBankDetails(@RequestParam(value = "document") String document) {
        PersonEntity entity;
        if (document.length() == 11){
            entity = personService.getPersonByCpf(document);
        }
        else if (document.length() == 14){
            entity = personService.getPersonByCnpj(document);
        }
        else {
            throw new HttpBadRequestException(DOCUMENTO_INVALIDO);
        }
        if (entity != null) {
            List<BankDetailsDTO> bank = bankDetailsEntityConverter.toDTOList(entity.getBanksDetails());

            return new ResponseEntity<>(bank, HttpStatus.CREATED);
        }
        throw new HttpNotFoundException(PESSOA_NAO_LOCALIZADA);
    }

    @ApiOperation(value = "URL to add bank details", authorizations = { @Authorization(value="jwtToken")})
    @PostMapping(path = "/persons/bankDetails")
    public ResponseEntity<PersonBankDetailsDTO> postBankDetails(@Validated @RequestBody PersonBankDetailsDTO dto) {
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
        throw new HttpNotFoundException(PESSOA_NAO_LOCALIZADA);
    }

    @ApiOperation(value = "URL to update bank details")
    @PutMapping(path = "/persons/bankDetails")
    public ResponseEntity<PersonBankDetailsDTO> putBankDetails(@Validated @RequestBody PersonBankDetailsDTO dto) {
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
            bankDetailsService.putBankDetails(dto, entity);

            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }
        throw new HttpNotFoundException(PESSOA_NAO_LOCALIZADA);
    }
}
