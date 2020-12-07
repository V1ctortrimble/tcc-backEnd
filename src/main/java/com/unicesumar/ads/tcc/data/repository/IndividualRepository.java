package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.IndividualEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndividualRepository extends PagingAndSortingRepository<IndividualEntity, Integer> {

    Page<IndividualEntity> findAllByActive(Boolean active, Pageable pageable);
    Page<IndividualEntity> findByCpfAndActive(Optional<String> cpf, Boolean active, Pageable pageable);
    Page<IndividualEntity> findByRgAndActive(Optional<String> rg, Boolean active, Pageable pageable);
    Page<IndividualEntity> findByCpfAndRgAndActive(Optional<String> cpf, Optional<String> rg, Boolean active,
                                                   Pageable pageable);
    Page<IndividualEntity> findByNameIndividualIgnoreCaseContainingAndActive(Optional<String> name, Boolean active,
                                                                             Pageable pageable);
    Page<IndividualEntity> findByLastNameIgnoreCaseContainingAndActive(Optional<String> lastName, Boolean active,
                                                                       Pageable pageable);
    Page<IndividualEntity> findByNameIndividualIgnoreCaseContainingAndLastNameIgnoreCaseContainingAndActive(Optional<String>
                                                                                                                    name,
                                                                                                            Optional<String>
                                                                                                                    lastName,
                                                                                                            Boolean active,
                                                                                                            Pageable pageable);
    Page<IndividualEntity> findByCpfAndNameIndividualIgnoreCaseContainingAndActive(Optional<String>cpf,
                                                                                   Optional<String>name, Boolean active,
                                                                                   Pageable pageable);
    Page<IndividualEntity> findByCpfAndLastNameIgnoreCaseContainingAndActive(Optional<String>cpf,
                                                                             Optional<String> lastName, Boolean active,
                                                                             Pageable pageable);

    IndividualEntity findIndividualByIdIndividual(Integer idIndividual);

}