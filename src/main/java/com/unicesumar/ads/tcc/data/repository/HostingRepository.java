package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.HostingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostingRepository extends JpaRepository<HostingEntity, Integer> {
}