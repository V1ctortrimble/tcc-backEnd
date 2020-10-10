package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.data.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
    public void postUsers(UsersEntity entity) {
        repository.save(entity);
    }

    /**
     * Find All Users
     */
    public List<UsersEntity> getUsers() {
        return repository.findAll();
    }

    /**
     * Validates that the password change code is valid
     */
    public UsersEntity getUserChangePass(String code) {
        UsersEntity user = repository.findByCode(code);

        if(user != null){
            double horaAtual = LocalDateTime.now().getHour();
            double horaToken = user.getDataCode().getHour();
            if( horaAtual - horaToken > 1 ){
                return null;
            }
            return user;
        }
        return null;
    }
}
