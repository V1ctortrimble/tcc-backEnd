package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.TravelPackageEntityConverter;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.service.TravelPackageService;
import com.unicesumar.ads.tcc.util.PDFGenerator;
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

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.FALHA_AO_SALVAR_PDF;
import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.PDF_SALVO;

@Api(tags = {"visualization of List Passanger"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('ADMIN')")
public class TravelContractController {

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
    private final PDFGenerator pdfGenerator;


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
