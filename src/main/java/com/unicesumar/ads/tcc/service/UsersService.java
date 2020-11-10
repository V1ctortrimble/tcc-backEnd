package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.converter.ContactEntityConverter;
import com.unicesumar.ads.tcc.converter.ContactEntityPostConverter;
import com.unicesumar.ads.tcc.converter.UsersEntityConverter;
import com.unicesumar.ads.tcc.converter.UsersEntityPostConverter;
import com.unicesumar.ads.tcc.data.entity.*;
import com.unicesumar.ads.tcc.data.repository.*;
import com.unicesumar.ads.tcc.dto.UsersDTO;
import com.unicesumar.ads.tcc.dto.usersPostDTO.UsersPostDTO;
import com.unicesumar.ads.tcc.util.PasswordEncoderUtil;
import com.unicesumar.ads.tcc.util.ValidatePasswordUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;
    private final PasswordEncoderUtil passwordEncoder;
    private final ValidatePasswordUtil validatePassword;
    private final ContactRepository contactRepository;
    private final CompanySystemRepository companySystemRepository;
    private final PersonRepository repositoryPerson;
    private final UsersEntityConverter usersEntityConverter;
    private final UsersEntityPostConverter usersEntityPostConverter;
    private final ContactEntityConverter contactEntityConverter;
    private final ContactEntityPostConverter contactEntityPostConverter;

    /**
     * Find UsersEntity by login
     */
    public UsersEntity getUserByLogin(String login) {
        return repository.findByUsername(login);

    }
    public UsersDTO getUserByUserName(String login) {
        UsersEntity entity = repository.findByUsername(login);
        UsersDTO user = usersEntityConverter.toDTO(entity);
        if (entity.getIndividual().getPersonEntity().getContacts() != null){
            user.setContact(contactEntityConverter.toDTO(entity.getIndividual().getPersonEntity().getContacts().get(0)));
        }
        return user;
    }

    /**
     * Save or update a UsersEntity
     */
    public void postUsers(UsersPostDTO dto) {
        List<ContactEntity> contacts = new ArrayList<ContactEntity>();
        contacts.add(contactEntityPostConverter.toEntity(dto.getContactDTO()));
        PersonEntity person = new PersonEntity();
        UsersEntity entity = usersEntityPostConverter.toEntity(dto);
        person.setIndividual(entity.getIndividual());
        person.getIndividual().setUsersEntity(entity);
        person.setContacts(contacts);
        person.getIndividual().getUsersEntity().setCompanySystem(companySystemRepository.findByIdCompanySystem(dto.getCompanySystem().getIdCompanySystem()));

        repositoryPerson.save(person);
    }

    /**
     * Find All Users
     */
    public List<UsersDTO> getUsers() {
        List<UsersEntity> users = repository.findAll();
        List<UsersDTO> list = usersEntityConverter.toDTOList(users);
        for(int i = 0; i < users.size(); i++){
            if (users.get(i).getIndividual().getPersonEntity().getContacts() != null){
                list.get(i).setContact(
                        contactEntityConverter.toDTO(users.get(0).getIndividual().getPersonEntity().getContacts().get(0)));
            }
        }
        return list;
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

    //TODO: Refatorar Metodo Adiconar !ISEMPTY
    public void putUsers(UsersDTO dto) {
        UsersEntity user = getUserByLogin(dto.getUsername());

        if (dto.getAdmin() != null){
            user.setAdmin(dto.getAdmin());
        }
        if (dto.getActive() != null){
            user.setActive(dto.getActive());
        }
        if (dto.getPassword() != null){
            validatePassword.getMatcher(dto.getPassword());
            user.setPassword(passwordEncoder.encodePassword(dto.getPassword()));
        }
        if (dto.getUsername() != null){
            user.setUsername(dto.getUsername());
        }
        if (dto.getCompanySystem() != null){
            if (user.getCompanySystem() == null)
                user.setCompanySystem(new CompanySystemEntity());

            user.getCompanySystem().setIdCompanySystem(dto.getCompanySystem().getIdCompanySystem());
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
        if (dto.getContact() != null){
            ContactEntity contact = contactRepository.findByIdContact(dto.getContact().getIdContact());
            if ( dto.getContact().getCellwhats() != null){
                contact.setCellwhats(dto.getContact().getCellwhats());
            }
            if ( !dto.getContact().getCellPhone().isEmpty() || dto.getContact().getCellPhone() != null){
                contact.setCellPhone(dto.getContact().getCellPhone());
            }
            if (dto.getContact().getEmail() != null){
                contact.setEmail(dto.getContact().getEmail());
            }
            if (dto.getContact().getPhone() != null){
                contact.setPhone(dto.getContact().getPhone());
            }
            contactRepository.save(contact);
        }
        repository.save(user);
    }
}
