package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.VehicleTypeEntity;
import com.unicesumar.ads.tcc.dto.VehicleTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleTypeEntity, Integer> {

    VehicleTypeEntity getByIdVehicleType(Integer id);

}