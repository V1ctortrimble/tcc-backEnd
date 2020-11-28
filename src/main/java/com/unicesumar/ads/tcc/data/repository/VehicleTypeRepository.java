package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.VehicleTypeEntity;
import com.unicesumar.ads.tcc.dto.VehicleTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

//TODO: Realizar code review

public interface VehicleTypeRepository extends JpaRepository<VehicleTypeEntity, Integer> {

    VehicleTypeEntity findByIdVehicleType(Integer id);

    List<VehicleTypeEntity> findAllByNameVehicleTypeContains(String nameVehicleType);

}