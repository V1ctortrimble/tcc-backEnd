package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.BankDetailsEntity;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.data.repository.BankDetailsRepository;
import com.unicesumar.ads.tcc.dto.personDTO.PersonBankDetailsDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.unicesumar.ads.tcc.service.constants.ServiceConstants.CAMPOS_OBRIGATORIOS;

@Service
@RequiredArgsConstructor
public class BankDetailsService {

    private final BankDetailsRepository bankDetailsRepository;

    /**
     * Save a BankDetails
     */
    public void postBankDetails(BankDetailsEntity entity) {
        try {
            bankDetailsRepository.save(entity);
        }catch (NullPointerException e) {
            throw new HttpBadRequestException(CAMPOS_OBRIGATORIOS);
        }
    }

    /**
     * update a BankDetails
     */
    public void putBankDetails(PersonBankDetailsDTO dto, PersonEntity person) {
        BankDetailsEntity bank = new BankDetailsEntity();
        for (BankDetailsEntity listBank : person.getBanksDetails()){
            if (dto.getBanksDetails().getIdBankDetails().equals(listBank.getIdBankDetails())){
                bank.setIdBankDetails(listBank.getIdBankDetails());
                bank.setPerson(person);
                if (dto.getBanksDetails() != null){
                    bank.setBank(dto.getBanksDetails().getBank());
                }
                if (dto.getBanksDetails() != null){
                    bank.setOperation(dto.getBanksDetails().getOperation());
                }
                if (dto.getBanksDetails() != null){
                    bank.setDigit(dto.getBanksDetails().getDigit());
                }
                if (dto.getBanksDetails() != null) {
                    bank.setAccount(dto.getBanksDetails().getAccount());
                }
                if (dto.getBanksDetails() != null) {
                    bank.setActive(dto.getBanksDetails().getActive());
                }
                assert dto.getBanksDetails() != null;
                if (dto.getBanksDetails().getAgency() != null){
                    bank.setAgency(dto.getBanksDetails().getAgency());
                }
            }
        }
        try {
            bankDetailsRepository.save(bank);
        }catch (NullPointerException e) {
            throw new HttpBadRequestException(CAMPOS_OBRIGATORIOS);
        }
    }

}
