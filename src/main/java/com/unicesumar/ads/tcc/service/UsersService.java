package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.data.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public UsersEntity getUserChangePass(String code) {
        UsersEntity user = repository.findByCode(code);

        double horaAtual = LocalDateTime.now().getHour();
        double horaToken = user.getDataCode().getHour();

        if( horaAtual - horaToken > 1 ){
            return null;
        }else{
            return user;
        }
    }
}
