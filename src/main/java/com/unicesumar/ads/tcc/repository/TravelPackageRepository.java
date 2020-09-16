package com.unicesumar.ads.tcc.repository;

import com.unicesumar.ads.tcc.entity.TravelPackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackageEntity, Integer> {
}