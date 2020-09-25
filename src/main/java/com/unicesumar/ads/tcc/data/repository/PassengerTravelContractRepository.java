package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.PassengerTravelContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerTravelContractRepository extends JpaRepository<PassengerTravelContractEntity, Integer> {
}