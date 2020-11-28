package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.TravelPackageEntityConverter;
import com.unicesumar.ads.tcc.data.entity.TravelPackageEntity;
import com.unicesumar.ads.tcc.dto.TravelPackageDTO;
import com.unicesumar.ads.tcc.service.TravelPackageService;
import com.unicesumar.ads.tcc.util.PaginatorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = {"visualization of Travel Package"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('ADMIN')")
public class TravelPackageController {

    /**
     * Services
     */
    private final TravelPackageService travelPackageService;

    /**
     * Converters
     */
    private final TravelPackageEntityConverter travelPackageEntityConverter;

    /**
     * Utils
     */
    private final PaginatorUtil paginator;

    /**
     * GetsMapping
     */
    @ApiOperation(value = "URL to return individual by cpf, name, last name, rg or return all individuals",
            authorizations = {@Authorization(value="jwtToken")})
    @GetMapping(path = "/travelpackage/all")
    public ResponseEntity<List<TravelPackageDTO>> getTravelPackageAll() {
        List<TravelPackageEntity> entities = new ArrayList<>();
        entities = travelPackageService.getTravelPackage();
        List<TravelPackageDTO> dtos = travelPackageEntityConverter.toDTOList(entities);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
