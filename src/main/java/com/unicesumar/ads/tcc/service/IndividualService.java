package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.IndividualEntity;
import com.unicesumar.ads.tcc.data.repository.IndividualRepository;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.unicesumar.ads.tcc.service.constants.ServiceConstants.PASSE_ALGUM_DADO_PARA_REALIZAR_A_BUSCA;

@Service
@RequiredArgsConstructor
public class IndividualService {


    private final IndividualRepository individualRepository;

    /**
     * Find All Individuals
     */
    public List<IndividualEntity> getIndividuals() {
        return individualRepository.findAll();
    }

    /**
     * Find Persons by  cpf, name, last name or birth date
     */
    public List<IndividualEntity> getIndividualFilter(Optional<String> cpf,
                                                       Optional<String> rg,
                                                       Optional<String> name,
                                                       Optional<String> lastName) {


        if (name.isPresent() && !lastName.isPresent()){
            return individualRepository.findByNameIndividualIgnoreCaseContaining(name);
        }
        if (!name.isPresent() && lastName.isPresent()) {
            return individualRepository.findByLastNameIgnoreCaseContaining(lastName);
        }
        if (name.isPresent()) {
            return individualRepository.findByNameIndividualIgnoreCaseContainingAndLastNameIgnoreCaseContaining(name,
                    lastName);
        }
        if (cpf.isPresent() && rg.isPresent()) {
            return individualRepository.findByCpfAndRg(cpf, rg);
        }
        if (rg.isPresent()) {
            return individualRepository.findByRg(rg);
        }
        if (cpf.isPresent()) {
            return individualRepository.findByCpf(cpf);
        }
        throw new HttpBadRequestException(PASSE_ALGUM_DADO_PARA_REALIZAR_A_BUSCA);
    }
}

