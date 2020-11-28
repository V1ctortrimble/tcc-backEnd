package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.hosting.HostingPostEntityConverter;
import com.unicesumar.ads.tcc.converter.hosting.HostingPutEntityConverter;
import com.unicesumar.ads.tcc.converter.hosting.PersonHostingEntityConverter;
import com.unicesumar.ads.tcc.data.entity.HostingEntity;
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

    /**
     * Converters
     */
    private final HostingPostEntityConverter hostingPostEntityConverter;
    private final HostingPutEntityConverter hostingPutEntityConverter;
    private final PersonHostingEntityConverter personHostingEntityConverter;

    /**
     * Services
     */
    private final HostingService hostingService;
    private final PersonService personService;

    /**
     * PostsMapping
     */
    @ApiOperation(value = "URL to add hosting", authorizations = {@Authorization(value="jwtToken") })
    @PostMapping(path = "/hosting")
    public ResponseEntity<HostingPostDTO> postHosting(@Validated @RequestBody HostingPostDTO dto){

        if (dto.getCnpj() != null){
            if (dto.getCnpj().length() == 14) {
                dto.setPerson(personHostingEntityConverter.toDTO(personService.getPersonByCnpj(dto.getCnpj())));
                hostingService.postHosting(hostingPostEntityConverter.toEntity(dto));
                return new ResponseEntity<>(dto, HttpStatus.OK);
            }
            throw new HttpBadRequestException(DOCUMENTO_INVALIDO);
        }
        throw new HttpBadRequestException(HOSTING_VAZIO);
    }

    /**
     * PutsMapping
     */
    @ApiOperation(value = "URL to update hosting", authorizations = {@Authorization(value="jwtToken") })
    @PutMapping(path = "/hosting")
    public ResponseEntity<HostingPutDTO> putHosting(@Validated @RequestBody HostingPutDTO dto){
        if (dto.getCnpj() != null){
            if (dto.getCnpj().length() == 14) {
                dto.setPerson(personHostingEntityConverter.toDTO(personService.getPersonByCnpj(dto.getCnpj())));
                hostingService.postHosting(hostingPutEntityConverter.toEntity(dto));
                return new ResponseEntity<>(dto, HttpStatus.OK);
            }
            throw new HttpBadRequestException(DOCUMENTO_INVALIDO);
        }
        throw new HttpBadRequestException(HOSTING_VAZIO);
    }

    /**
     * GetsMapping
     */
    @ApiOperation(value = "URL to hosting get by document ", authorizations = {@Authorization(value="jwtToken") })
    @GetMapping(path = "/hosting")
    public ResponseEntity<List<HostingPutDTO>> getAllByDocument(@RequestParam(value = "cnpj") String cnpj){
        List<HostingEntity> entities = hostingService.getAllHostingsByCnpj(cnpj, true);
        if(entities.size() > 0){
            List<HostingPutDTO> dtos = hostingPutEntityConverter.toDTOList(entities);
            if (cnpj.length() == 14) {
                return  new ResponseEntity<>(dtos, HttpStatus.OK);
            }
            throw new HttpBadRequestException(DOCUMENTO_INVALIDO);
        }
        throw new HttpNotFoundException(HOSPEDAGEM_NAO_ENCONTRADO);
    }
}
