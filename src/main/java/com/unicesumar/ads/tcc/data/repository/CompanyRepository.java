package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.CompanyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<CompanyEntity, Integer> {

    Page<CompanyEntity> findAllByActive(Boolean active, Pageable pageable);
    Page<CompanyEntity> findByCnpjAndActive(Optional<String> cnpj, Boolean active, Pageable pageable);
    Page<CompanyEntity> findByStateRegisAndActive(Optional<String> stateRegis, Boolean active, Pageable pageable);
    Page<CompanyEntity> findByCnpjAndStateRegisAndActive(Optional<String> cnpj, Optional<String> stateRegis, Boolean active,
                                                         Pageable pageable);
    Page<CompanyEntity> findByFantasyNameIgnoreCaseContainingAndActive(Optional<String> fantasyName, Boolean active,
                                                                       Pageable pageable);
    Page<CompanyEntity> findBySocialReasonIgnoreCaseContainingAndActive(Optional<String> socialReason, Boolean active,
                                                                        Pageable pageable);
    Page<CompanyEntity> findByFantasyNameIgnoreCaseContainingAndSocialReasonIgnoreCaseContainingAndActive(Optional<String>
                                                                                                         fantasyName,
                                                                                                          Optional<String>
                                                                                                         socialReason,
                                                                                                          Boolean active,
                                                                                                          Pageable pageable);
    Page<CompanyEntity> findByCnpjAndFantasyNameIgnoreCaseContainingAndActive(Optional<String>cnpj,
                                                                              Optional<String>fantasyName,
                                                                              Boolean active,
                                                                              Pageable pageable);
    Page<CompanyEntity> findByCnpjAndSocialReasonIgnoreCaseContainingAndActive(Optional<String>cnpj,
                                                                               Optional<String> socialReason,
                                                                               Boolean active,
                                                                               Pageable pageable);
}