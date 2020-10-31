package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
}