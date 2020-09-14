package com.unicesumar.ads.tcc.repository;

import com.unicesumar.ads.tcc.entity.CompanyPartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyPartnerRepository extends JpaRepository<CompanyPartnerEntity, Integer> {
}