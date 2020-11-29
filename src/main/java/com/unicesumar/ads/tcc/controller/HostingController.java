package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.hosting.*;
import com.unicesumar.ads.tcc.data.entity.HostingEntity;
import com.unicesumar.ads.tcc.data.entity.HostingTypeEntity;
import com.unicesumar.ads.tcc.dto.hostingPostDTO.HostingPostDTO;
import com.unicesumar.ads.tcc.dto.hostingPostDTO.HostingTypePostDTO;
import com.unicesumar.ads.tcc.dto.hostingPutDTO.HostingPutDTO;
import com.unicesumar.ads.tcc.dto.hostingPutDTO.HostingTypePutDTO;
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
    private final HostingTypePutEntityConverter hostingTypePutEntityConverter;
    private final HostingTypePostEntityConverter hostingTypePostEntityConverter;

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

    /**
     * GetsMapping
     */
    @ApiOperation(value = "URL to hosting get by ID ", authorizations = {@Authorization(value="jwtToken") })
    @GetMapping(path = "/hosting/id")
    public ResponseEntity<HostingPutDTO> getById(@RequestParam(value = "id") Integer id){
        if(id != null){
            HostingEntity entity = hostingService.getHostingById(id);
            if( entity != null ){
                HostingPutDTO dto = hostingPutEntityConverter.toDTO(entity);
                return  new ResponseEntity<>(dto, HttpStatus.OK);
            }
            throw new HttpNotFoundException(HOSPEDAGEM_NAO_ENCONTRADO);
        }
        throw new HttpNotFoundException(NECESSARIO_ENVIAR_ID);
    }

    /**
     * PostsMapping
     */
    @ApiOperation(value = "URL to add hosting type", authorizations = {@Authorization(value="jwtToken") })
    @PostMapping(path = "/hostingtype")
    public ResponseEntity<HostingTypePostDTO> postHostingType(@Validated @RequestBody HostingTypePostDTO dto){

        if (dto != null){
            hostingService.postHostingType(hostingTypePostEntityConverter.toEntity(dto));
            return new ResponseEntity<>(dto, HttpStatus.OK);
            }
        throw new HttpBadRequestException(HOSTING_VAZIO);
        }


    /**
     * GetsMapping
     */
    @ApiOperation(value = "URL to get all hosting type ", authorizations = {@Authorization(value="jwtToken") })
    @GetMapping(path = "/hostingtype")
    public ResponseEntity<List<HostingTypePutDTO>> getAllHostingType(){
        List<HostingTypeEntity> entities = hostingService.getAllHostingType();
        if(entities.size() > 0){
            List<HostingTypePutDTO> dtos = hostingTypePutEntityConverter.toDTOList(entities);
            return  new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        throw new HttpNotFoundException(HOSPEDAGEM_NAO_ENCONTRADO);
    }
}
