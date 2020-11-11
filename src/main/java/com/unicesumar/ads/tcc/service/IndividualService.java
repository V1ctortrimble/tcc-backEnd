package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.IndividualEntity;
import com.unicesumar.ads.tcc.data.repository.IndividualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IndividualService {

    private final IndividualRepository individualRepository;

    /**
     * Find All Individuals
     */
    public Page<IndividualEntity> getIndividuals(Pageable pageable) {
        return individualRepository.findAll(pageable);
    }

    /**
     * Find Persons by  cpf, name, last name or rg
     */
    public Page<IndividualEntity> getIndividualFilter(Optional<String> cpf, Optional<String> rg, Optional<String> name,
                                                      Optional<String> lastName,
                                                      Boolean active,
                                                      Pageable pageable) {
        cpf = validationCpfIsEmpty(cpf);
        rg = validationRgIsEmpty(rg);
        name = validationNameIsEmpty(name);
        lastName = validationLastNameIsEmpty(lastName);
        return getIndividualByFilters(cpf, rg, name, lastName, active, pageable);
    }

    /**
     * Select find according to parameters passed in the URL
     */
    private Page<IndividualEntity> getIndividualByFilters(Optional<String> cpf, Optional<String> rg,
                                                          Optional<String> name, Optional<String> lastName,
                                                          Boolean active,
                                                          Pageable pageable) {
        if(cpf.isPresent() && name.isPresent()) {
           return individualRepository.findByCpfAndNameIndividualIgnoreCaseContainingAndActive(cpf, name, active, pageable);
        }
        if(cpf.isPresent() && lastName.isPresent()) {
            return individualRepository.findByCpfAndLastNameIgnoreCaseContainingAndActive(cpf, lastName, active, pageable);
        }
        if (name.isPresent() && lastName.isPresent()) {
            return individualRepository.findByNameIndividualIgnoreCaseContainingAndLastNameIgnoreCaseContainingAndActive(name,
                    lastName, active, pageable);
        }
        if (name.isPresent()){
            return individualRepository.findByNameIndividualIgnoreCaseContainingAndActive(name, active, pageable);
        }
        if (lastName.isPresent()) {
            return individualRepository.findByLastNameIgnoreCaseContainingAndActive(lastName, active, pageable);
        }
        if (cpf.isPresent() && rg.isPresent()) {
            return individualRepository.findByCpfAndRgAndActive(cpf, rg, active, pageable);
        }
        if (rg.isPresent()) {
            return individualRepository.findByRgAndActive(rg, active, pageable);
        }
        if (cpf.isPresent()) {
            return individualRepository.findByCpfAndActive(cpf, active, pageable);
        }
        return individualRepository.findAllByActive(active, pageable);
    }

    /**
     * Method that validates if an empty string in cpf
     */
    private Optional<String> validationCpfIsEmpty(Optional<String> cpf) {
        if (cpf.isPresent() && cpf.get().equals("")) {
            cpf = Optional.empty();
        }
        return cpf;
    }

    /**
     * Method that validates if an empty string in rg
     */
    private Optional<String> validationRgIsEmpty(Optional<String> rg) {
        if (rg.isPresent() && rg.get().equals("")) {
            rg = Optional.empty();
        }
        return rg;
    }

    /**
     * Method that validates if an empty string in name
     */
    private Optional<String> validationNameIsEmpty(Optional<String> name) {
        if (name.isPresent() && name.get().equals("")) {
            name = Optional.empty();
        }
        return name;
    }

    /**
     * Method that validates if an empty string in lastName
     */
    private Optional<String> validationLastNameIsEmpty(Optional<String> lastName) {
        if (lastName.isPresent() && lastName.get().equals("")) {
            lastName = Optional.empty();
        }
        return lastName;
    }

}