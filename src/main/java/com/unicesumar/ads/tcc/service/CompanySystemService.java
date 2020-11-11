package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.CompanySystemEntity;
import com.unicesumar.ads.tcc.data.repository.CompanySystemRepository;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.unicesumar.ads.tcc.service.constants.ServiceConstants.CAMPOS_OBRIGATORIOS;

@Service
@RequiredArgsConstructor
public class CompanySystemService {

    private final CompanySystemRepository companySystemRepository;

    /**
     * Save a PersonEntity
     */
    public void postCompanySystem(CompanySystemEntity entity) {
        try {
            companySystemRepository.save(entity);
        }catch (NullPointerException e) {
            throw new HttpBadRequestException(CAMPOS_OBRIGATORIOS);
        }
    }

    /**
     * Find CompanySystemEntity by cpf
     */
    public CompanySystemEntity getCompanySystemByCnpj(String cnpj) {
        return companySystemRepository.findByCompanyCnpj(cnpj);
    }

    /**
     * Find All CompanySystemEntity by active true
     */
    public List<CompanySystemEntity> getAllCompanySystem(Boolean active) {
         return companySystemRepository.findAllByCompanyActive(active);
    }
}
