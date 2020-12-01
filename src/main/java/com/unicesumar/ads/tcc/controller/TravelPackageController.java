package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.TravelPackageEntityConverter;
import com.unicesumar.ads.tcc.data.entity.TravelPackageEntity;
import com.unicesumar.ads.tcc.dto.TravelPackageDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.service.TravelPackageService;
import com.unicesumar.ads.tcc.util.PDFGenerator;
import com.unicesumar.ads.tcc.util.PaginatorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.FALHA_AO_SALVAR_PDF;
import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.PDF_SALVO;

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
    private final PDFGenerator pdfGenerator;

    /**
     * GetsMapping
     */
    @ApiOperation(value = "URL to return all travelpackage",
            authorizations = {@Authorization(value="jwtToken")})
    @GetMapping(path = "/travelpackage/all")
    public ResponseEntity<List<TravelPackageDTO>> getTravelPackageAll() {
        List<TravelPackageEntity> entities = new ArrayList<>();
        entities = travelPackageService.getTravelPackage();
        List<TravelPackageDTO> dtos = travelPackageEntityConverter.toDTOList(entities);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    /**
     * GetsMapping
     */
    @ApiOperation(value = "URL to return by codigo, nome, local origem, local destino, or return all travelpackage",
            authorizations = {@Authorization(value="jwtToken")})
    @GetMapping(path = "/travelpackage/filter")
    public ResponseEntity<Page<TravelPackageDTO>> getTravelPackageFilter(Pageable pageable,
                                                                         @RequestParam(value = "idtravelpackge",
                                                                                 required = false)
                                                                                 Integer idTravelPackge,
                                                                         @RequestParam(value = "nametravelpackge",
                                                                                 required = false)
                                                                                 Optional<String> nameTravelPackge,
                                                                         @RequestParam(value = "originname",
                                                                                 required = false)
                                                                                     Optional<String> originName,
                                                                         @RequestParam(value = "destinationName",
                                                                                 required = false)
                                                                                     Optional<String> destinationName,
                                                                         @RequestParam(value = "active",
                                                                                 defaultValue = "true",
                                                                                 required = false)
                                                                                     Boolean active) {
        Page<TravelPackageDTO> dtos = paginator.convertDTOTravelPackageToPages(idTravelPackge, nameTravelPackge,
                originName, destinationName, active, pageable);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @ApiOperation(value = "URL to return PDF List of Passengers",
            authorizations = {@Authorization(value="jwtToken")})
    @GetMapping(path = "/list/pdf")
    public ResponseEntity<?> getListPdf() {
        try {
            pdfGenerator.createPdfReport(travelPackageEntityConverter.toDTOList(travelPackageService.getTravelPackage()));
            return new ResponseEntity<>(PDF_SALVO, HttpStatus.OK);
        } catch (final Exception e) {
            e.printStackTrace();
            throw new HttpBadRequestException(FALHA_AO_SALVAR_PDF);
        }
    }
}
