package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.CompanyEntity;
import com.unicesumar.ads.tcc.data.entity.CompanySystemEntity;
import com.unicesumar.ads.tcc.data.repository.CompanyRepository;
import com.unicesumar.ads.tcc.data.repository.CompanySystemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    /**
     * Find All Companies
     */
    public Page<CompanyEntity> getCompanies(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    /**
     * Find Company by cnpj
     */
    public CompanyEntity getCompanyByCnpj(String cnpj) {
        return  companyRepository.findByCnpj(cnpj);
    }

    /**
     * Find Persons by  cpf, name, last name or birth date
     */
    public Page<CompanyEntity> getIndividualFilter(Optional<String> cnpj, Optional<String> socialReason,
                                                      Optional<String> fantasyName,
                                                      Optional<String> stateRegis,
                                                      Boolean active,
                                                      Pageable pageable) {
        cnpj = validationCnpjIsEmpty(cnpj);
        socialReason = validationSocialReasonIsEmpty(socialReason);
        fantasyName = validationFantasyNameIsEmpty(fantasyName);
        stateRegis = validationStateRegisIsEmpty(stateRegis);
        return getCompanyByFilters(cnpj, socialReason, fantasyName, stateRegis, active, pageable);
    }

    /**
     * Select find according to parameters passed in the URL
     */
    private Page<CompanyEntity> getCompanyByFilters(Optional<String> cnpj, Optional<String> socialReason,
                                                    Optional<String> fantasyName,
                                                    Optional<String> stateRegis,
                                                    Boolean active,
                                                    Pageable pageable) {
        if(cnpj.isPresent() && fantasyName.isPresent()) {
            return companyRepository.findByCnpjAndFantasyNameIgnoreCaseContainingAndActive(cnpj, fantasyName, active, pageable);
        }
        if(cnpj.isPresent() && socialReason.isPresent()) {
            return companyRepository.findByCnpjAndSocialReasonIgnoreCaseContainingAndActive(cnpj, socialReason, active, pageable);
        }
        if (fantasyName.isPresent() && socialReason.isPresent()) {
            return companyRepository.findByFantasyNameIgnoreCaseContainingAndSocialReasonIgnoreCaseContainingAndActive(fantasyName,
                    socialReason, active, pageable);
        }
        if (fantasyName.isPresent()){
            return companyRepository.findByFantasyNameIgnoreCaseContainingAndActive(fantasyName, active, pageable);
        }
        if (socialReason.isPresent()) {
            return companyRepository.findBySocialReasonIgnoreCaseContainingAndActive(socialReason, active, pageable);
        }
        if (cnpj.isPresent() && stateRegis.isPresent()) {
            return companyRepository.findByCnpjAndStateRegisAndActive(cnpj, stateRegis, active, pageable);
        }
        if (stateRegis.isPresent()) {
            return companyRepository.findByStateRegisAndActive(stateRegis, active, pageable);
        }
        if (cnpj.isPresent()) {
            return companyRepository.findByCnpjAndActive(cnpj, active, pageable);
        }
        return companyRepository.findAllByActive(active, pageable);
    }

    /**
     * Method that validates if an empty string in cnpj
     */
    private Optional<String> validationCnpjIsEmpty(Optional<String> cnpj) {
        if (cnpj.isPresent() && cnpj.get().equals("")) {
            cnpj = Optional.empty();
        }
        return cnpj;
    }

    /**
     * Method that validates if an empty string in socialReason
     */
    private Optional<String> validationSocialReasonIsEmpty(Optional<String> socialReason) {
        if (socialReason.isPresent() && socialReason.get().equals("")) {
            socialReason = Optional.empty();
        }
        return socialReason;
    }

    /**
     * Method that validates if an empty string in fantasyName
     */
    private Optional<String> validationFantasyNameIsEmpty(Optional<String> fantasyName) {
        if (fantasyName.isPresent() && fantasyName.get().equals("")) {
            fantasyName = Optional.empty();
        }
        return fantasyName;
    }

    /**
     * Method that validates if an empty string in stateRegis
     */
    private Optional<String> validationStateRegisIsEmpty(Optional<String> stateRegis) {
        if (stateRegis.isPresent() && stateRegis.get().equals("")) {
            stateRegis = Optional.empty();
        }
        return stateRegis;
    }

}
