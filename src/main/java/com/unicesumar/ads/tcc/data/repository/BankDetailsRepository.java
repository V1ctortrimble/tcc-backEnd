package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.BankDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetailsEntity, Integer> {
}