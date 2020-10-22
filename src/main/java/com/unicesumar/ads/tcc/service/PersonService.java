package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.data.repository.PersonRepository;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    public static final String CAMPOS_OBRIGATORIOS = "Campos obrigatórios vazios";

    private final PersonRepository repository;

    /**
     * Find PersonEntity by cnpj
     */
    public PersonEntity getPersonByCnpj(String cnpj) {
        return repository.findByCompanyCnpj(cnpj);
    }

    /**
     * Find PersonEntity by cpf
     */
    public PersonEntity getPersonByCpf(String cpf) {
        return repository.findByIndividualCpf(cpf);
    }

    /**
     * Save or update a PersonEntity
     */
    public void postUsers(PersonEntity entity) {
       try {
           repository.save(entity);
       }catch (NullPointerException e) {
           throw new HttpBadRequestException(CAMPOS_OBRIGATORIOS);
       }
    }

    /**
     * Find All Persons
     */
    public List<PersonEntity> getPerson() {
        return repository.findAll();
    }

}
