package com.unicesumar.ads.tcc.repository;

import com.unicesumar.ads.tcc.entity.TravelPackgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPackgeRepository extends JpaRepository<TravelPackgeEntity, Integer> {
}