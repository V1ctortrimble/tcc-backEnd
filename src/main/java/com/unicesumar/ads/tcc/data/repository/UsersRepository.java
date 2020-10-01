package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

    UsersEntity findByUsername(String username);

    UsersEntity findByCode(String code);
}