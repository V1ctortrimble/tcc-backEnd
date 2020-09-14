package com.unicesumar.ads.tcc.repository;

import com.unicesumar.ads.tcc.entity.VehicleTravelPackgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTravelPackgeRepository extends JpaRepository<VehicleTravelPackgeEntity, Integer> {
}