package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.CompanyPartnerEntity;
import com.unicesumar.ads.tcc.data.repository.CompanyPartnerRepository;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.unicesumar.ads.tcc.service.constants.ServiceConstants.CAMPOS_OBRIGATORIOS;

@Service
@RequiredArgsConstructor
public class CompanyPartnerService {

    private final CompanyPartnerRepository companyPartnerRepository;

    /**
     * Save a CompanyPartnerEntity
     */
    public void postCompanyPartner(CompanyPartnerEntity entity) {
        try {
            companyPartnerRepository.save(entity);
        }catch (NullPointerException e) {
            throw new HttpBadRequestException(CAMPOS_OBRIGATORIOS);
        }
    }

    /**
    * Find CompanyPartnerEntity by id
    */
    public CompanyPartnerEntity getCompanyPartnerByCpfIndividual(String cpf) {
        return companyPartnerRepository.getByIndividualCpf(cpf);
    }

    /**
     * * Find CompanyPartnerEntity by active
     */
    public List<CompanyPartnerEntity> getCompanyPartners(String cnpj) {
        return companyPartnerRepository.getByActiveAndCompanySystemCompanyCnpj(true, cnpj);
    }
}
