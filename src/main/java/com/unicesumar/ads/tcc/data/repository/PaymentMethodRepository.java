package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Integer> {
}