package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.IndividualEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndividualRepository extends PagingAndSortingRepository<IndividualEntity, Integer> {

    Page<IndividualEntity> findByCpf(Optional<String> cpf, Pageable pageable);
    Page<IndividualEntity> findByRg(Optional<String> rg, Pageable pageable);
    Page<IndividualEntity> findByCpfAndRg(Optional<String> cpf, Optional<String> rg, Pageable pageable);
    Page<IndividualEntity> findByNameIndividualIgnoreCaseContaining(Optional<String> name, Pageable pageable);
    Page<IndividualEntity> findByLastNameIgnoreCaseContaining(Optional<String> lastName, Pageable pageable);
    Page<IndividualEntity> findByNameIndividualIgnoreCaseContainingAndLastNameIgnoreCaseContaining(Optional<String>
                                                                                                           name,
                                                                                                   Optional<String>
                                                                                                           lastName,
                                                                                                   Pageable pageable);
    Page<IndividualEntity> findByCpfAndNameIndividualIgnoreCaseContaining(Optional<String>cpf, Optional<String>name,
                                                                          Pageable pageable);
    Page<IndividualEntity> findByCpfAndLastNameIgnoreCaseContaining(Optional<String>cpf, Optional<String> lastName,
                                                                    Pageable pageable);

}