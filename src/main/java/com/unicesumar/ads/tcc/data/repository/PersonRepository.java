package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    PersonEntity findByIndividualCpf(String cpf);

    PersonEntity findByCompanyCnpj(String cnpj);
}