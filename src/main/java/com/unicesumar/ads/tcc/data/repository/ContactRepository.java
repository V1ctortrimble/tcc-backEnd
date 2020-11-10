package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {
    ContactEntity findByIdContact(Integer idContact);
}