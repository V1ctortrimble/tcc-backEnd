package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.VehicleEntity;
import com.unicesumar.ads.tcc.data.entity.VehicleTypeEntity;
import com.unicesumar.ads.tcc.data.repository.VehicleRepository;
import com.unicesumar.ads.tcc.data.repository.VehicleTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleTypeRepository vehicleTypeRepository;
    private final VehicleRepository vehicleRepository;

    /**
     * Find Vehicle type By id
     */
    public VehicleTypeEntity getVehicleTypeById(Integer id){
        return vehicleTypeRepository.findByIdVehicleType(id);
    }

    /**
     * Find all Vehicle By active
     */
    public List<VehicleEntity> getAllVehicleByActive(){
        return vehicleRepository.findAllByActive(true);
    }

    /**
     * Find all Vehicle type By cnpj
     */
    public List<VehicleEntity> getAllVehicleTypeByCnpj(String cnpj){
        return vehicleRepository.findAllByCompanyCnpjStartsWithAndActive(cnpj, true);
    }

    /**
     * Find all Vehicle type
     */
    public List<VehicleTypeEntity> getAllByNameVehicleType(String name){
        return vehicleTypeRepository.findAllByNameVehicleTypeContains(name);
    }

    /**
     * Save or update Vehicle type
     */
    public void postVehicleType(VehicleTypeEntity entity)
    {
        vehicleTypeRepository.save(entity);
    }

    /**
     * Save or update Vehicle
     */
    public void PostVehicle(VehicleEntity entity){
        vehicleRepository.save(entity);
    }

}
