package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.CompanyPartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyPartnerRepository extends JpaRepository<CompanyPartnerEntity, Integer> {
}