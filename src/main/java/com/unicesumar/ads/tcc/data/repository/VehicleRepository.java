package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {
    List<VehicleEntity> findAllByActive(Boolean active);

    List<VehicleEntity> findAllByCompanyCnpjStartsWithAndActive(String cnpj, Boolean active);
}