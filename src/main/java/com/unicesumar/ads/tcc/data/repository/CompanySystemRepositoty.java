package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.CompanySystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySystemRepositoty extends JpaRepository<CompanySystemEntity, Integer> {
}