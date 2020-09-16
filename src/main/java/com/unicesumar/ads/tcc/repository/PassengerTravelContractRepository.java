package com.unicesumar.ads.tcc.repository;

import com.unicesumar.ads.tcc.entity.PassengerTravelContractDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerTravelContractRepository extends JpaRepository<PassengerTravelContractDTO, Integer> {
}