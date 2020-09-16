package com.unicesumar.ads.tcc.repository;

import com.unicesumar.ads.tcc.entity.PersonDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonDTO, Integer> {
}