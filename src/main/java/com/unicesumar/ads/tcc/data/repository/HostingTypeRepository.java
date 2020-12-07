package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.HostingTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostingTypeRepository extends JpaRepository<HostingTypeEntity, Integer> {
}