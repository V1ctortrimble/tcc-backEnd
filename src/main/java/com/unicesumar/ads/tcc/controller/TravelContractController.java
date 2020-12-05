package com.unicesumar.ads.tcc.controller;

import com.sun.mail.iap.Response;
import com.unicesumar.ads.tcc.converter.TravelPackageEntityConverter;
import com.unicesumar.ads.tcc.converter.travelContract.PassengerTravelContractPostEntityConverter;
import com.unicesumar.ads.tcc.converter.travelContract.TravelContractGetEntityConverter;
import com.unicesumar.ads.tcc.converter.travelContract.TravelContractPostEntityConverter;
import com.unicesumar.ads.tcc.converter.vehicle.CompanyPutEntityConverter;
import com.unicesumar.ads.tcc.data.entity.*;
import com.unicesumar.ads.tcc.dto.TravelContractDTO;
import com.unicesumar.ads.tcc.dto.TravelContractGetDTO.TravelContractGetDTO;
import com.unicesumar.ads.tcc.dto.TravelPackageDTO;
import com.unicesumar.ads.tcc.dto.travelContractPostDTO.PassengerTravelContractPostDTO;
import com.unicesumar.ads.tcc.dto.travelContractPostDTO.TravelContractPostDTO;
import com.unicesumar.ads.tcc.dto.vehiclePutDTO.CompanyPutDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import com.unicesumar.ads.tcc.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    private final CompanyService companyService;
    private final TravelPackageService travelPackageService;
    private final TravelContractService travelContractService;
    private final PassengerTravelContractService passengerTravelContractService;
    private final IndividualService individualService;

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
                        PassengerTravelContractEntity valdition = passengerTravelContractService.getValidation(
                                                                    entityPassenger.getIndividual().getIdIndividual(),
                                                                    entityPassenger.getTravelContract().getIdTravelContract());
                        if (valdition != null){
                            entityRetorno.getPassengerTravelContracts().add(passengerTravelContractService.postPassengerTravelContract(entityPassenger));
                        }
                        else {
                            throw new HttpBadRequestException("Passageiro já cadastrado para o contrato");
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
                        entityPassenger.setPayingPassenger(passenger.getPayingPassenger());
                        entityPassenger.setTravelContract(entityRetorno);
                        entityRetorno.getPassengerTravelContracts().add(passengerTravelContractService.postPassengerTravelContract(entityPassenger));
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

}
