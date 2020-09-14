package com.unicesumar.ads.tcc.repository;

import com.unicesumar.ads.tcc.entity.HostingTravelPackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostingTravelPackageRepository extends JpaRepository<HostingTravelPackageEntity, Integer> {
}