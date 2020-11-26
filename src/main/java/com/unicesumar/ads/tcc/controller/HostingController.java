package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.hosting.HostingPostEntityConverter;
import com.unicesumar.ads.tcc.converter.hosting.HostingPutEntityConverter;
import com.unicesumar.ads.tcc.converter.hosting.PersonHostingEntityConverter;
import com.unicesumar.ads.tcc.dto.hostingPostDTO.HostingPostDTO;
import com.unicesumar.ads.tcc.dto.hostingPutDTO.HostingPutDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.*;

@Api(tags = {"visualization of Hostings"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class HostingController {

    private final HostingPostEntityConverter hostingPostEntityConverter;
    private final HostingPutEntityConverter hostingPutEntityConverter;
    private final PersonHostingEntityConverter personHostingEntityConverter;

    private final HostingService hostingService;
    private final PersonService personService;

    /**
     * Post Hosting
     */
    @ApiOperation(value = "URL to add hosting", authorizations = {@Authorization(value="jwtToken") })
    @PostMapping(path = "/hosting")
    public ResponseEntity<HostingPostDTO> postHosting(@Validated @RequestBody HostingPostDTO dto){

        if (dto.getDocument() != null){
            if (dto.getDocument().length() == 14) {
                dto.setPerson(personHostingEntityConverter.toDTO(personService.getPersonByCnpj(dto.getDocument())));
            }
            else if (dto.getDocument().length() == 11){
                dto.setPerson(personHostingEntityConverter.toDTO(personService.getPersonByCpf(dto.getDocument())));
            }
        }
        else {
            throw new HttpBadRequestException(DOCUMENTO_INVALIDO);
        }


        if (dto != null){
            hostingService.postHost(hostingPostEntityConverter.toEntity(dto));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException(HOSTING_VAZIO);
    }

    /**
     * Put Hosting
     */
    @ApiOperation(value = "URL to update hosting", authorizations = {@Authorization(value="jwtToken") })
    @PutMapping(path = "/hosting")
    public ResponseEntity<HostingPutDTO> putHosting(@Validated @RequestBody HostingPutDTO dto){
        if (dto.getDocument() != null){
            if (dto.getDocument().length() == 14) {
                dto.setPerson(personHostingEntityConverter.toDTO(personService.getPersonByCnpj(dto.getDocument())));
            }
            else if (dto.getDocument().length() == 11){
                dto.setPerson(personHostingEntityConverter.toDTO(personService.getPersonByCpf(dto.getDocument())));
            }
            else {
                throw new HttpBadRequestException(DOCUMENTO_INVALIDO);
            }
        }

        if (dto != null){
            hostingService.postHost(hostingPutEntityConverter.toEntity(dto));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException(HOSTING_VAZIO);
    }

    /**
     * get Hosting
     */
    @ApiOperation(value = "URL to hosting get by document ", authorizations = {@Authorization(value="jwtToken") })
    @GetMapping(path = "/hosting")
    public ResponseEntity<List<HostingPutDTO>> getAllByDocument(@RequestParam(value = "document") String document){
        List<HostingPutDTO> dtos;
        if (document.length() == 14) {
            dtos = hostingPutEntityConverter.toDTOList(hostingService.getAllByCnpj(document));
        }
        else if (document.length() == 11){
            dtos = hostingPutEntityConverter.toDTOList(hostingService.getAllByCpf(document));
        }
        else {
            throw new HttpBadRequestException(DOCUMENTO_INVALIDO);
        }

        if(dtos.size() > 0){
            return  new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        throw new HttpNotFoundException(HOSPEDAGEM_NAO_ENCONTRADO);
    }



}
