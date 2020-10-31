package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.person.PersonCompanyEntityConverter;
import com.unicesumar.ads.tcc.data.entity.CompanyPartnerEntity;
import com.unicesumar.ads.tcc.data.entity.CompanySystemEntity;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.dto.CompanyPartnerDTO;
import com.unicesumar.ads.tcc.dto.companyDTO.CompanySystemDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.service.CompanyPartnerService;
import com.unicesumar.ads.tcc.service.CompanySystemService;
import com.unicesumar.ads.tcc.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"visualization of CompanySystem"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
public class CompanySystemController {

    public static final String PESSOA_NAO_CADASTRADA = "Pessoa não cadastrada";
    private final PersonCompanyEntityConverter personCompanyEntityConverter;
    private final CompanySystemService companySystemService;
    private final CompanyPartnerService companyPartnerService;
    private final PersonService personService;

    @ApiOperation(value = "URL to add Company System")
    @PostMapping(path = "/companySystem")
    public ResponseEntity<CompanySystemDTO> PostCompanySystem(@Validated @RequestBody CompanySystemDTO dto) {

        PersonEntity entity = personService.getPersonByCnpj(dto.getCnpj());

        if( entity != null){
            CompanySystemEntity companySystem = new CompanySystemEntity();
            companySystem.setCompany(entity.getCompany());

            companySystemService.postCompanySystem(companySystem);

            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException(PESSOA_NAO_CADASTRADA);
    }

    @ApiOperation(value = "URL to add Company System")
    @PostMapping(path = "/companyPartner")
    public ResponseEntity<CompanyPartnerDTO> PostCompanyPartner(@Validated @RequestBody CompanyPartnerDTO dto) {

        PersonEntity entity = personService.getPersonByCpf(dto.getCpf());
        CompanySystemEntity entityCompanySystem = companySystemService.getCompanySystemByCnpj(dto.getCnpj());

        if( entity != null && entityCompanySystem != null){
            CompanyPartnerEntity companyPartner = new CompanyPartnerEntity();
            companyPartner.setCompanySystem(entityCompanySystem);
            companyPartner.setIndividual(entity.getIndividual());
            companyPartner.setActive(true);

            companyPartnerService.postCompanyPartner(companyPartner);

            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException(PESSOA_NAO_CADASTRADA);
    }
}
