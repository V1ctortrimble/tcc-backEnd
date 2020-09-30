package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.data.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;

    /**
     * Find UsersEntity by login
     */
    public UsersEntity getUserByLogin(String login) {
        return repository.findByUsername(login);
    }

    /**
     * Save or update a UsersEntity
     */
    public UsersEntity postUsers(UsersEntity entity) {
        return repository.save(entity);
    }
}
