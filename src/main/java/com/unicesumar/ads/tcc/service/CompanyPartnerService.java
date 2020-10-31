package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.CompanyPartnerEntity;
import com.unicesumar.ads.tcc.data.repository.CompanyPartnerRepository;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyPartnerService {

    public static final String CAMPOS_OBRIGATORIOS = "Campos obrigatórios vazios";
    private final CompanyPartnerRepository repository;

    /**
     * Save or update a PersonEntity
     */
    public void postCompanyPartner(CompanyPartnerEntity entity) {
        try {
            repository.save(entity);
        }catch (NullPointerException e) {
            throw new HttpBadRequestException(CAMPOS_OBRIGATORIOS);
        }
    }
}
