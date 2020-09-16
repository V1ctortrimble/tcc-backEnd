package com.unicesumar.ads.tcc.repository;

import com.unicesumar.ads.tcc.entity.HostingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostingRepository extends JpaRepository<HostingDTO, Integer> {
}