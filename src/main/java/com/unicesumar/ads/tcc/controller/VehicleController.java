package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.*;
import com.unicesumar.ads.tcc.converter.vehicle.*;
import com.unicesumar.ads.tcc.data.entity.VehicleEntity;
import com.unicesumar.ads.tcc.data.entity.VehicleTypeEntity;
import com.unicesumar.ads.tcc.data.repository.CompanyRepository;
import com.unicesumar.ads.tcc.dto.CompanyDTO;
import com.unicesumar.ads.tcc.dto.VehicleDTO;
import com.unicesumar.ads.tcc.dto.VehicleTypeDTO;
import com.unicesumar.ads.tcc.dto.vehicleGetDTO.VehicleGetDTO;
import com.unicesumar.ads.tcc.dto.vehicleGetDTO.VehicleTypeGetDTO;
import com.unicesumar.ads.tcc.dto.vehiclePostDTO.VehiclePostDTO;
import com.unicesumar.ads.tcc.dto.vehiclePostDTO.VehicleTypePostDTO;
import com.unicesumar.ads.tcc.dto.vehiclePutDTO.VehiclePutDTO;
import com.unicesumar.ads.tcc.dto.vehiclePutDTO.VehicleTypePutDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
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
import com.unicesumar.ads.tcc.service.VehicleService;

import java.util.List;

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.*;


@Api(tags = {"visualization of Vehicles"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class VehicleController {

    /**
     * Services
     */
    private final VehicleService vehicleService;
    private final PersonService personService;
    private final CompanyRepository companyRepository;

    /**
     * Converters
     */
    private final VehicleTypePostEntityConverter vehicleTypePostConverter;
    private final VehicleTypeEntityConverter vehicleTypeEntityConverter;
    private final VehicleEntityConverter vehicleEntityConverter;
    private final VehiclePutEntityConverter vehiclePutEntityConverter;
    private final CompanyEntityConverter companyEntityConverter;
    private final VehicleGetEntityConverter vehicleGetEntityConverter;
    private final VehicleTypeGetEntityConverter vehicleTypeGetEntityConverter;

    /**
     * Post Vechile Type
     */
    @ApiOperation(value = "URL to add type of vehicles", authorizations = {@Authorization(value="jwtToken") })
    @PostMapping(path = "/vehicles/type")
    public ResponseEntity<VehicleTypePostDTO> postTypeVehicle(@Validated @RequestBody VehicleTypePostDTO dto)
    {
        if (dto != null){
            vehicleService.postTypeVehicle(vehicleTypePostConverter.toEntity(dto));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException(VEICULO_VAZIO);
    }

    /**
     * Post Vechile - Company
     */
    @ApiOperation(value = "URL to add vehicles", authorizations = {@Authorization(value="jwtToken") })
    @PostMapping(path = "/vehicles")
    public ResponseEntity<VehiclePostDTO> postVehicle(@Validated @RequestBody VehiclePostDTO dto)
    {
        CompanyDTO company = companyEntityConverter.toDTO(companyRepository.findByCnpj(dto.getCnpj()));
        VehicleTypeDTO vehicleType = vehicleTypeEntityConverter.toDTO(vehicleService.getVehicleTypeById(dto.getIdVehicleType()));
        VehicleDTO vehicle = new VehicleDTO();
        vehicle.setCompanyDTO(company);
        vehicle.setRntrc(dto.getRntrc());
        vehicle.setVehicleTypeDTO(vehicleType);
        vehicle.setActive(true);
        if (dto != null){
            vehicleService.PostVehicle(vehicleEntityConverter.toEntity(vehicle));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException(VEICULO_VAZIO);
    }

    /**
     * Put Vechile Type
     */
    @ApiOperation(value = "URL to add type of vehicles", authorizations = {@Authorization(value="jwtToken") })
    @PutMapping(path = "/vehicles/type")
    public ResponseEntity<VehicleTypePutDTO> putTypeVehicle(@Validated @RequestBody VehicleTypePutDTO dto){
        VehicleTypeEntity entity = vehicleService.getVehicleTypeById(dto.getIdVehicleType());
        if (entity != null){
            vehicleService.putVehicleType(entity);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpNotFoundException(VEICULO_NAO_ENCONTRADO);
    }

    /**
     * Put Vechile - Company
     */
    @ApiOperation(value = "URL to update vehicles", authorizations = {@Authorization(value="jwtToken") })
    @PutMapping(path = "/vehicles")
    public ResponseEntity<VehiclePutDTO> putVehicle(@Validated @RequestBody VehiclePutDTO dto)
    {
        CompanyDTO company = companyEntityConverter.toDTO(companyRepository.findByCnpj(dto.getCnpj()));;
        VehicleTypeDTO vehicleType = vehicleTypeEntityConverter.toDTO(vehicleService.getVehicleTypeById(dto.getIdVehicleType()));
        VehiclePutDTO vehicle = new VehiclePutDTO();
        vehicle.setCompanyDTO(company);
        vehicle.setRntrc(dto.getRntrc());
        vehicle.setVehicleType(vehicleType);
        vehicle.setIdVehicle(dto.getIdVehicle());
        vehicle.setActive(dto.getActive());
        if (dto != null){
            vehicleService.PostVehicle(vehiclePutEntityConverter.toEntity(vehicle));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException(VEICULO_VAZIO);
    }

    /**
     * Get Vechile - Company activated
     */
    @ApiOperation(value = "URL to get vehicles activated", authorizations = {@Authorization(value="jwtToken") })
    @GetMapping(path = "/vehicles")
    public ResponseEntity<List<VehicleGetDTO>> getVehicle()
    {
        List<VehicleGetDTO> dtos = vehicleGetEntityConverter.toDTOList(vehicleService.getAllVehicleByActive());
        if (dtos.size() > 0){
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        throw new HttpNotFoundException("Nenhum veiculo encontrado!");
    }

    /**
     * Get Vechile type activated and by cnpj
     */
    @ApiOperation(value = "URL to get vehicles activated", authorizations = {@Authorization(value="jwtToken") })
    @GetMapping(path = "/vehicles/cnpj")
    public ResponseEntity<List<VehicleGetDTO>> getTypeVehicleByCnpj(@RequestParam(value = "cnpj") String cnpj)
    {
        List<VehicleGetDTO> dtos = vehicleGetEntityConverter.toDTOList(vehicleService.getAllTypeVehicleByCnpj(cnpj));
        if (dtos.size() > 0){
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        throw new HttpNotFoundException("Nenhum veiculo encontrado!");
    }

    /**
     * Get Vechile type activated and by cnpj
     */
    @ApiOperation(value = "URL to get vehicles activated", authorizations = {@Authorization(value="jwtToken") })
    @GetMapping(path = "/vehiclesType")
    public ResponseEntity<List<VehicleTypeGetDTO>> getAllTypeVehicle(@RequestParam(value = "name") String name)
    {
        List<VehicleTypeGetDTO> dtos = vehicleTypeGetEntityConverter.toDTOList(vehicleService.getAllVehicleType(name));
        if (dtos.size() > 0){
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        throw new HttpNotFoundException("Nenhum veiculo encontrado!");
    }

}
