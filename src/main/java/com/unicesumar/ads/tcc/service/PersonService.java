package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.data.repository.PersonRepository;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.unicesumar.ads.tcc.service.constants.ServiceConstants.CAMPOS_OBRIGATORIOS;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    /**
     * Find PersonEntity by cnpj
     */
    public PersonEntity getPersonByCnpj(String cnpj) {
        return personRepository.findByCompanyCnpj(cnpj);
    }

    /**
     * Find PersonEntity by cpf
     */
    public PersonEntity getPersonByCpf(String cpf) {
        return personRepository.findByIndividualCpf(cpf);
    }

    /**
     * Find PersonEntity by rg
     */
    public PersonEntity getPersonByRg(String rg) {
        return personRepository.findByIndividualRg(rg);
    }

    /**
     * Save or update a PersonEntity
     */
    public void postUsers(PersonEntity entity) {
       try {
           personRepository.save(entity);
       }catch (NullPointerException e) {
           throw new HttpBadRequestException(CAMPOS_OBRIGATORIOS);
       }
    }

    /**
     * Find All Persons
     */
    public List<PersonEntity> getPerson() {
        return personRepository.findAll();
    }

}
