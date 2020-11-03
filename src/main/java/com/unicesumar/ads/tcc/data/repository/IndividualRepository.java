package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.IndividualEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IndividualRepository extends JpaRepository<IndividualEntity, Integer> {

    List<IndividualEntity> findByCpf(Optional<String> cpf);
    List<IndividualEntity> findByRg(Optional<String> rg);
    List<IndividualEntity> findByCpfAndRg(Optional<String> cpf, Optional<String> rg);
    List<IndividualEntity> findByNameIndividualIgnoreCaseContaining(Optional<String> name);
    List<IndividualEntity> findByLastNameIgnoreCaseContaining(Optional<String> lastName);
    List<IndividualEntity> findByNameIndividualIgnoreCaseContainingAndLastNameIgnoreCaseContaining(Optional<String> name,
                                                                                                   Optional<String> lastName);
}