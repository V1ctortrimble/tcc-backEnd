package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.hosting.HostingPostEntityConverter;
import com.unicesumar.ads.tcc.converter.hosting.PersonHostingEntityConverter;
import com.unicesumar.ads.tcc.dto.hostingPostDTO.HostingPostDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.service.HostingService;
import com.unicesumar.ads.tcc.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"visualization of Hostings"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class HostingController {

    private final HostingPostEntityConverter hostingPostEntityConverter;
    private final PersonHostingEntityConverter personHostingEntityConverter;

    private final HostingService hostingService;
    private final PersonService personService;


    /**
     * Post Hosting
     */
    @ApiOperation(value = "URL to add hosting", authorizations = {@Authorization(value="jwtToken") })
    @PostMapping(path = "/hosting")
    public ResponseEntity<HostingPostDTO> postHosting(@Validated @RequestBody HostingPostDTO dto){
        if (dto != null){
            dto.setPerson(personHostingEntityConverter.toDTO(personService.getPersonByCnpj(dto.getCnpj())));
            hostingService.postHost(hostingPostEntityConverter.toEntity(dto));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException("HOSTING VAZIO!!!");
    }


}
