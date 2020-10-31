package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.CompanyEntity;
import com.unicesumar.ads.tcc.data.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    /**
     * Find All Companies
     */
    public List<CompanyEntity> getCompanies() {
        return companyRepository.findAll();
    }

}
