package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.BankDetailsEntity;
import com.unicesumar.ads.tcc.data.repository.BankDetailsRepository;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankDetailsService {

    public static final String CAMPOS_OBRIGATORIOS = "Campos obrigatórios vazios";
    private final BankDetailsRepository repository;

    /**
     * Save or update a BankDetails
     */
    public void postBankDetails(BankDetailsEntity entity) {
        try {
            repository.save(entity);
        }catch (NullPointerException e) {
            throw new HttpBadRequestException(CAMPOS_OBRIGATORIOS);
        }
    }
}
