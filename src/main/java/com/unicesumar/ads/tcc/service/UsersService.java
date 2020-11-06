package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.CompanySystemEntity;
import com.unicesumar.ads.tcc.data.entity.IndividualEntity;
import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.data.repository.UsersRepository;
import com.unicesumar.ads.tcc.dto.UsersDTO;
import com.unicesumar.ads.tcc.util.PasswordEncoderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;
    private final PasswordEncoderUtil passwordEncoder;

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

    public void putUsers(UsersDTO dto) {
        UsersEntity user = getUserByLogin(dto.getUsername());
        if (dto.getAdmin() != null){
            user.setAdmin(dto.getAdmin());
        }
        if (dto.getPassword() != null){
            user.setPassword(passwordEncoder.encodePassword(dto.getPassword()));
        }
        if (dto.getUsername() != null){
            user.setUsername(dto.getUsername());
        }
        if (dto.getCompanySystemDTO() != null){
            if (user.getCompanySystem() == null)
                user.setCompanySystem(new CompanySystemEntity());

            user.getCompanySystem().setIdCompanySystem(dto.getCompanySystemDTO().getIdCompanySystem());
        }
        if (dto.getIndividual() != null){
            if (user.getIndividual() == null)
                user.setIndividual(new IndividualEntity());

            if (dto.getIndividual().getIdIndividual() != null) {
                user.getIndividual().setIdIndividual(dto.getIndividual().getIdIndividual());
            }
            if (dto.getIndividual().getCpf() != null) {
                user.getIndividual().setCpf(dto.getIndividual().getCpf());
            }
            if (dto.getIndividual().getActive() != null) {
                user.getIndividual().setActive(dto.getIndividual().getActive());
            }
            if (dto.getIndividual().getNameIndividual() != null) {
                user.getIndividual().setNameIndividual(dto.getIndividual().getNameIndividual());
            }
            if (dto.getIndividual().getRg() != null) {
                user.getIndividual().setRg(dto.getIndividual().getRg());
            }
            if (dto.getIndividual().getLastName() != null) {
                user.getIndividual().setLastName(dto.getIndividual().getLastName());
            }
            if (dto.getIndividual().getBirthDate() != null) {
                user.getIndividual().setBirthDate(dto.getIndividual().getBirthDate());
            }
        }

        repository.save(user);
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
