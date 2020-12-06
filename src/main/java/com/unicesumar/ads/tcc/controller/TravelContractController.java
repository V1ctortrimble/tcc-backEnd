package com.unicesumar.ads.tcc.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.converter.TravelContractPdfDTOConverter;
import com.unicesumar.ads.tcc.converter.TravelPackageEntityConverter;
import com.unicesumar.ads.tcc.converter.travelContract.PassengerTravelContractPostEntityConverter;
import com.unicesumar.ads.tcc.converter.travelContract.TravelContractGetEntityConverter;
import com.unicesumar.ads.tcc.converter.travelContract.TravelContractPostEntityConverter;
import com.unicesumar.ads.tcc.converter.vehicle.CompanyPutEntityConverter;
import com.unicesumar.ads.tcc.data.entity.*;
import com.unicesumar.ads.tcc.dto.IndividualListPdfDTO;
import com.unicesumar.ads.tcc.dto.TravelContractGetDTO.TravelContractGetDTO;
import com.unicesumar.ads.tcc.dto.contractDTO.TravelContractPdfDTO;
import com.unicesumar.ads.tcc.dto.listPassengerPdfDTO.TravelPackagePdfListDTO;
import com.unicesumar.ads.tcc.dto.travelContractPostDTO.IndividualPostTravelContractDTO;
import com.unicesumar.ads.tcc.dto.travelContractPostDTO.PassengerTravelContractPostDTO;
import com.unicesumar.ads.tcc.dto.travelContractPostDTO.TravelContractPostDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import com.unicesumar.ads.tcc.service.*;
import com.unicesumar.ads.tcc.util.PDFGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.*;

@Api(tags = {"visualization of Travel Contract"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('ADMIN')")
public class TravelContractController {

    private final TravelContractPostEntityConverter travelContractPostEntityConverter;
    private final CompanyPutEntityConverter companyPutEntityConverter;
    private final TravelPackageEntityConverter travelPackageEntityConverter;
    private final PassengerTravelContractPostEntityConverter passengerTravelContractPostEntityConverter;
    private final TravelContractGetEntityConverter travelContractGetEntityConverter;
    private final TravelContractPdfDTOConverter travelContractPdfDTOConverter;

    private final CompanyService companyService;
    private final TravelPackageService travelPackageService;
    private final TravelContractService travelContractService;
    private final PassengerTravelContractService passengerTravelContractService;
    private final IndividualService individualService;

    private final PDFGenerator pdfGenerator;

    /**
     * PostsMapping
     */
    @ApiOperation(value = "URL to add travel contract", authorizations = {@Authorization(value="jwtToken")})
    @PostMapping(path = "/travelcontract")
    public ResponseEntity<TravelContractPostDTO> postTravelContract(@Validated @RequestBody TravelContractPostDTO dto){
        try {
            if (dto != null){
                TravelContractEntity entity = new TravelContractEntity();
                if (dto.getIdCompany() != null){
                    CompanyEntity company = companyService.getCompanyById(dto.getIdCompany());
                    if (company != null){
                        entity.setCompany(company);
                    }
                    else {
                        throw new HttpNotFoundException(NENHUMA_EMPRESA_LOCALIZADA);
                    }
                }
                if (dto.getIdTravelPackage() != null){
                    TravelPackageEntity travelPackage = travelPackageService.getTravelPackageById(dto.getIdTravelPackage());
                    if (travelPackage != null){
                        entity.setTravelPackage(travelPackage);
                    }
                    else{
                        throw new HttpNotFoundException(NENHUM_PACOTEVIAGEM_ENCONTRADO);
                    }
                }
                entity.setBoardingLocation(dto.getBoardingLocation());
                entity.setBoardingTime(dto.getBoardingTime());
                entity.setIssueDate(dto.getIssueDate());
                entity.setTotalContractAmount(dto.getTotalContractAmount());
                entity.setLandingLocation(dto.getLandingLocation());
                entity.setActive(dto.getActive());
                TravelContractEntity entityRetorno = travelContractService.postTravelContract(entity);
                entityRetorno.setPassengerTravelContracts(new ArrayList<>());
                if (dto.getPassengerTravelContracts() != null) {
                    dto.getPassengerTravelContracts().add(dto.getPassengerTravelContract());
                }
                else{
                    dto.setPassengerTravelContracts(new ArrayList<>());
                    dto.getPassengerTravelContracts().add(dto.getPassengerTravelContract());
                }
                if (dto.getPassengerTravelContracts().get(0) != null){
                    for (PassengerTravelContractPostDTO passenger : dto.getPassengerTravelContracts()){
                        IndividualEntity individualEntity = individualService.getIndividualById(passenger.getIdIndividual());
                        PassengerTravelContractEntity entityPassenger = new PassengerTravelContractEntity();
                        entityPassenger.setContractedPassenger(passenger.getContractedPassenger());
                        entityPassenger.setIndividual(individualEntity);
                        entityPassenger.setPayingPassenger(passenger.getPayingPassenger());
                        entityPassenger.setTravelContract(entityRetorno);
                        PassengerTravelContractEntity validation = passengerTravelContractService.getValidation(
                                                                    entityPassenger.getIndividual().getIdIndividual(),
                                                                    entityPassenger.getTravelContract().getIdTravelContract());
                        PassengerTravelContractEntity validationTravelPackage = passengerTravelContractService.getValidationPackage(
                                                                    entityPassenger.getIndividual().getIdIndividual(),
                                                                    dto.getIdTravelPackage());
                        if (validation == null && validationTravelPackage == null){
                            entityRetorno.getPassengerTravelContracts().add(passengerTravelContractService.postPassengerTravelContract(entityPassenger));
                        }
                        else {
                            throw new HttpBadRequestException(PASSAGEIRO_JA_CADASTRADO_PARA_VIAGEM);
                        }
                    }
                }
                dto = travelContractPostEntityConverter.toDTO(entityRetorno);
            }
        }
        catch (Exception e){
            throw new HttpBadRequestException(e.getMessage());
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * PutMapping
     */
    @ApiOperation(value = "URL to update travel contract", authorizations = {@Authorization(value="jwtToken")})
    @PutMapping(path = "/travelcontract")
    public ResponseEntity<TravelContractPostDTO> putTravelContract(@Validated @RequestBody TravelContractPostDTO dto,
                                                                   @RequestParam(value = "id") Integer id){
        try{
            if (dto != null){
                TravelContractEntity entity = new TravelContractEntity();
                if (dto.getIdCompany() != null){
                    CompanyEntity company = companyService.getCompanyById(dto.getIdCompany());
                    if (company != null){
                        dto.setCompany(companyPutEntityConverter.toDTO(company));
                    }
                    else {
                        throw new HttpNotFoundException(NENHUMA_EMPRESA_LOCALIZADA);
                    }
                }
                if (dto.getIdTravelPackage() != null){
                    TravelPackageEntity travelPackage = travelPackageService.getTravelPackageById(dto.getIdTravelPackage());
                    if (travelPackage != null){
                        dto.setTravelPackage(travelPackageEntityConverter.toDTO(travelPackage));
                    }
                    else{
                        throw new HttpNotFoundException(NENHUM_PACOTEVIAGEM_ENCONTRADO);
                    }
                }
                dto.setIdTravelContract(id);
                TravelContractEntity entityRetorno = travelContractService.postTravelContract(travelContractPostEntityConverter.toEntity(dto));
                entityRetorno.setPassengerTravelContracts(new ArrayList<>());
                if (dto.getPassengerTravelContracts() != null) {
                    dto.getPassengerTravelContracts().add(dto.getPassengerTravelContract());
                }
                else{
                    dto.setPassengerTravelContracts(new ArrayList<>());
                    dto.getPassengerTravelContracts().add(dto.getPassengerTravelContract());
                }
                if (dto.getPassengerTravelContracts().get(0) != null){
                    for (PassengerTravelContractPostDTO passenger : dto.getPassengerTravelContracts()){
                        IndividualEntity individualEntity = individualService.getIndividualById(passenger.getIdIndividual());
                        PassengerTravelContractEntity entityPassenger = passengerTravelContractService.getById(passenger.getIdPassengerTravelContract());
                        entityPassenger.setContractedPassenger(passenger.getContractedPassenger());
                        entityPassenger.setIndividual(individualEntity);
                        entity.setActive(dto.getActive());
                        entityPassenger.setPayingPassenger(passenger.getPayingPassenger());
                        entityPassenger.setTravelContract(entityRetorno);
                        PassengerTravelContractEntity validation = passengerTravelContractService.getValidation(
                                entityPassenger.getIndividual().getIdIndividual(),
                                entityPassenger.getTravelContract().getIdTravelContract());
                        PassengerTravelContractEntity validationTravelPackage = passengerTravelContractService.getValidationPackage(
                                entityPassenger.getIndividual().getIdIndividual(),
                                dto.getIdTravelPackage());
                        if (validation == null && validationTravelPackage == null){
                            entityRetorno.getPassengerTravelContracts().add(passengerTravelContractService.postPassengerTravelContract(entityPassenger));
                        }
                        else {
                            throw new HttpBadRequestException(PASSAGEIRO_JA_CADASTRADO_PARA_VIAGEM);
                        }
                    }
                }
                dto = travelContractPostEntityConverter.toDTO(entityRetorno);
            }
        }
        catch (Exception e){
            throw new HttpBadRequestException(OCORREU_PROBLEMA);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * GetMapping
     */
    @ApiOperation(value = "URL to get travel contract", authorizations = {@Authorization(value="jwtToken")})
    @GetMapping(path = "/travelcontract/all")
    public ResponseEntity<List<TravelContractGetDTO>> getAllTravelContracts(){
        List<TravelContractEntity> entities = travelContractService.getAllTravelContracts();
        if (entities.size() > 0) {
            List<TravelContractGetDTO> dtos = travelContractGetEntityConverter.toDTOList(entities);
            for (TravelContractGetDTO dto : dtos){
                dto.setCompany(null);
                dto.setTravelPackage(null);
            }
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        throw new HttpNotFoundException(NENHUM_CONTRATOVIAGEM_ENCONTADO);
    }

    /**
     * GetMapping
     */
    @ApiOperation(value = "URL to get travel contract", authorizations = {@Authorization(value="jwtToken")})
    @GetMapping(path = "/travelcontract/id")
    public ResponseEntity<TravelContractGetDTO> getTravelContractById(@RequestParam(value = "id") Integer id){
        TravelContractEntity entity = travelContractService.getTravelContractById(id);
        if (entity != null)
            return new ResponseEntity<>(travelContractGetEntityConverter.toDTO(entity), HttpStatus.OK);
        throw new HttpNotFoundException(NENHUM_CONTRATOVIAGEM_ENCONTADO);
    }


    ///contract/pdf
    @ApiOperation(value = "URL to get travel contract too generate Pdf",
            authorizations = {@Authorization(value="jwtToken")})
    @GetMapping(path = "/contract/pdf")
    public ResponseEntity<?> getTravelContractByIdToGeneratePdf(
            @RequestParam(value = "id") Integer id){
        TravelContractEntity entity = travelContractService.getTravelContractById(id);

        List<IndividualPostTravelContractDTO> passengerList = new ArrayList<>();
        IndividualPostTravelContractDTO payingPassenger;
        IndividualPostTravelContractDTO passenger;
        String route;
        LocalDate startDate;
        LocalDate endDate;
        LocalTime expectedStartTime;
        LocalTime estimatedEndTime;

        String cpfPay;
        String rgPay;
        String nameIndividualPay;
        String lastNamePay;

        if(entity != null){
            TravelContractPdfDTO dto = travelContractPdfDTOConverter.toDTO(entity);
            //Individual que é o contratente ou acompanhante
            for (int i = 0; i < dto.getPassengerTravelContracts().size(); i++) {
                if (dto.getPassengerTravelContracts().get(i).getPayingPassenger()) {
                    payingPassenger = dto.getPassengerTravelContracts().get(i).getIndividual();
                    dto.getPassengerTravelContracts().get(i).setIndividualPay(payingPassenger);
                }
                //getter
                route = dto.getTravelPackage().getRoute();
                startDate = dto.getTravelPackage().getStartDate();
                endDate = dto.getTravelPackage().getEndDate();
                expectedStartTime = dto.getTravelPackage().getExpectedStartTime();
                estimatedEndTime = dto.getTravelPackage().getEstimatedEndTime();
                cpfPay = dto.getPassengerTravelContracts().get(i).getIndividualPay().getCpf();
                rgPay = dto.getPassengerTravelContracts().get(i).getIndividualPay().getRg();
                nameIndividualPay = dto.getPassengerTravelContracts().get(i).getIndividualPay().getNameIndividual();
                lastNamePay = dto.getPassengerTravelContracts().get(i).getIndividualPay().getLastName();

                //setter
                dto.setRoute(route);
                dto.setStartDate(startDate);
                dto.setEndDate(endDate);
                dto.setExpectedStartTime(expectedStartTime);
                dto.setEstimatedEndTime(estimatedEndTime);
                dto.setCpfPay(cpfPay);
                dto.setRgPay(rgPay);
                dto.setNameIndividualPay(nameIndividualPay);
                dto.setLastNamePay(lastNamePay);

                passenger = dto.getPassengerTravelContracts().get(i).getIndividual();
                passengerList.add(passenger);
            }
            try {
                pdfGenerator.createPdfReportContract(dto);
                return new ResponseEntity<>(PDF_SALVO, HttpStatus.OK);
            } catch (final Exception e) {
                e.printStackTrace();
                throw new HttpBadRequestException(FALHA_AO_SALVAR_PDF);
            }
        }
        throw  new HttpNotFoundException("nenhum contrato encontrado");
    }

// {
//        TravelPackageEntity entity = travelPackageService.getTravelPackageById(idTravelPackge);
//        List<IndividualListPdfDTO> passengerList = new ArrayList<>();
//        String nameTravelPackage;
//        if (entity != null) {
//            TravelPackagePdfListDTO dto = travelPackagePdfListConverter.toDTO(entity);
//            for (int i = 0; i < dto.getTravelContracts().size(); i++) {
//                IndividualListPdfDTO passenger = dto.getTravelContracts().get(i).getPassengerTravelContracts()
//                        .get(0).getIndividual();
//                nameTravelPackage = dto.getNameTravelPackage();
//                dto.getTravelContracts().get(i).getPassengerTravelContracts().get(0).getIndividual()
//                        .setNameTravelPackage(nameTravelPackage);
//                passengerList.add(passenger);
//            }
//            if (passengerList.size() == 0) {
//                throw new HttpNotFoundException(NENHUM_PASSAGEIRO_PARA_ESSA_VIAGEM);
//            }
//
//        }
//        throw new HttpNotFoundException(NENHUM_PACOTE_DE_VIAGEM_LOCALIZADO);
//    }

}
