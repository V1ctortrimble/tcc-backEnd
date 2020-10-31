package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.CompanyPartnerEntity;
import com.unicesumar.ads.tcc.data.entity.CompanySystemEntity;
import com.unicesumar.ads.tcc.data.repository.CompanySystemRepository;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanySystemService {

    public static final String CAMPOS_OBRIGATORIOS = "Campos obrigatórios vazios";

    private final CompanySystemRepository repository;

    /**
     * Save or update a PersonEntity
     */
    public void postCompanySystem(CompanySystemEntity entity) {
        try {
            repository.save(entity);
        }catch (NullPointerException e) {
            throw new HttpBadRequestException(CAMPOS_OBRIGATORIOS);
        }
    }

    /**
     * Find CompanySystemEntity by cpf
     */
    public CompanySystemEntity getCompanySystemByCnpj(String cnpj) {
        return repository.findByCompanyCnpj(cnpj);
    }
}
