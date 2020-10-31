package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.IndividualEntity;
import com.unicesumar.ads.tcc.data.repository.IndividualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
