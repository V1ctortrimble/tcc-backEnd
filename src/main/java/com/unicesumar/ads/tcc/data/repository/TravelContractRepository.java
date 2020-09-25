package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.TravelContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelContractRepository extends JpaRepository<TravelContractEntity, Integer> {
}