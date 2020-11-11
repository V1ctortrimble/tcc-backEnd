package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.CompanySystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanySystemRepository extends JpaRepository<CompanySystemEntity, Integer> {
    CompanySystemEntity findByCompanyCnpj(String cnpj);
    CompanySystemEntity findByIdCompanySystem(Integer idCompanySystem);
    List<CompanySystemEntity> findAllByCompanyActive(Boolean active);
}