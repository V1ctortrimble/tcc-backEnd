package com.unicesumar.ads.tcc.repository;

import com.unicesumar.ads.tcc.entity.AdressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<AdressEntity, Integer> {
}