package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.converter.ContactEntityConverter;
import com.unicesumar.ads.tcc.converter.ContactEntityPostConverter;
import com.unicesumar.ads.tcc.converter.UsersEntityConverter;
import com.unicesumar.ads.tcc.converter.UsersEntityPostConverter;
import com.unicesumar.ads.tcc.data.entity.*;
import com.unicesumar.ads.tcc.data.repository.CompanySystemRepository;
import com.unicesumar.ads.tcc.data.repository.ContactRepository;
import com.unicesumar.ads.tcc.data.repository.PersonRepository;
import com.unicesumar.ads.tcc.data.repository.UsersRepository;
import com.unicesumar.ads.tcc.dto.UsersDTO;
import com.unicesumar.ads.tcc.dto.usersPostDTO.UsersPostDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.util.PasswordEncoderUtil;
import com.unicesumar.ads.tcc.util.ValidatePasswordUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.unicesumar.ads.tcc.service.constants.ServiceConstants.USUARIO_SEM_CONTATO;

@Service
@RequiredArgsConstructor
public class UsersService {

    /**
     * Converters
     */
    private final UsersEntityConverter usersEntityConverter;
    private final UsersEntityPostConverter usersEntityPostConverter;
    private final ContactEntityConverter contactEntityConverter;
    private final ContactEntityPostConverter contactEntityPostConverter;

    /**
     * Utils
     */
    private final PasswordEncoderUtil passwordEncoder;
    private final ValidatePasswordUtil validatePassword;

    /**
     * Repository
     */
    private final UsersRepository usersRepository;
    private final ContactRepository contactRepository;
    private final CompanySystemRepository companySystemRepository;
    private final PersonRepository personRepository;


    /**
     * Find UsersEntity by login
     */
    public UsersEntity getUserByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    /**
     * Find for User and set up contact object within the user DTO
     */
    public UsersDTO getUserByUsernameBuildContact(String username) {
        UsersEntity entity = usersRepository.findByUsername(username);
        UsersDTO dto = usersEntityConverter.toDTO(entity);
        buildContactToUsers(entity, dto);
        return dto;
    }

    /**
     * Find Users by  cpf, name, last name or username
     */
    public Page<UsersEntity> getUsersFilter(Optional<String> username, Optional<String> name, Optional<String> lastName,
                                            Optional<String> cpf, Boolean active, Pageable pageable) {
        cpf = validationCpfIsEmpty(cpf);
        username = validationUsernameIsEmpty(username);
        name = validationNameIsEmpty(name);
        lastName = validationLastNameIsEmpty(lastName);
        return getUserByFilters(cpf, username, name, lastName, active, pageable);
    }

    /**
     * Select find according to parameters passed in the URL
     */
    private Page<UsersEntity> getUserByFilters(Optional<String> cpf, Optional<String> username,
                                               Optional<String> name, Optional<String> lastName,
                                               Boolean active,
                                               Pageable pageable) {
        if (username.isPresent() && name.isPresent()) {
            return usersRepository.
                    findByUsernameIgnoreCaseContainingAndIndividualNameIndividualIgnoreCaseContainingAndAndActive(username,
                            name, active, pageable);
        }
        if (username.isPresent() && lastName.isPresent()) {
            return usersRepository.
                    findByUsernameIgnoreCaseContainingAndIndividualLastNameIgnoreCaseContainingAndActive(username,
                            lastName, active, pageable);
        }
        if (cpf.isPresent() && name.isPresent() && lastName.isPresent()) {
            return usersRepository.findByIndividualCpfAndIndividualNameIndividualIgnoreCaseContainingAndIndividualLastNameIgnoreCaseContainingAndActive(cpf,
                    name, lastName, active, pageable);
        }
        if(cpf.isPresent() && name.isPresent()) {
            return usersRepository.findByIndividualCpfAndIndividualNameIndividualIgnoreCaseContainingAndActive(cpf,
                    name, active, pageable);
        }
        if(cpf.isPresent() && lastName.isPresent()) {
            return usersRepository.
                    findByIndividualCpfAndIndividualLastNameIgnoreCaseContainingAndActive(cpf, lastName, active,
                            pageable);
        }
        if (name.isPresent() && lastName.isPresent()) {
            return usersRepository.
                    findByIndividualNameIndividualIgnoreCaseContainingAndIndividualLastNameIgnoreCaseContainingAndActive(name,
                    lastName, active, pageable);
        }
        if (name.isPresent()){
            return usersRepository.findByIndividualNameIndividualIgnoreCaseContainingAndActive(name, active, pageable);
        }
        if (lastName.isPresent()) {
            return usersRepository.findByIndividualLastNameIgnoreCaseContainingAndActive(lastName, active, pageable);
        }
        if (username.isPresent()) {
            return usersRepository.findByUsernameIgnoreCaseContainingAndActive(username, active, pageable);
        }
        if (cpf.isPresent()) {
            return usersRepository.
                    findByIndividualCpfAndActive(cpf, active, pageable);
        }
        return usersRepository.findAllByActive(active, pageable);
    }

    /**
     * Method that validates if an empty string in username
     */
    private Optional<String> validationUsernameIsEmpty(Optional<String> username) {
        if(username.isPresent() && username.get().equals("")) {
            username = Optional.empty();
        }
        return username;
    }

    /**
     * Method that validates if an empty string in cpf
     */
    private Optional<String> validationCpfIsEmpty(Optional<String> cpf) {
        if (cpf.isPresent() && cpf.get().equals("")) {
            cpf = Optional.empty();
        }
        return cpf;
    }

    /**
     * Method that validates if an empty string in name
     */
    private Optional<String> validationNameIsEmpty(Optional<String> name) {
        if (name.isPresent() && name.get().equals("")) {
            name = Optional.empty();
        }
        return name;
    }

    /**
     * Method that validates if an empty string in lastName
     */
    private Optional<String> validationLastNameIsEmpty(Optional<String> lastName) {
        if (lastName.isPresent() && lastName.get().equals("")) {
            lastName = Optional.empty();
        }
        return lastName;
    }

    /**
     * Save a Users
     */
    public void postUsers(UsersPostDTO dto) {
        List<ContactEntity> contacts = new ArrayList<ContactEntity>();
        contacts.add(contactEntityPostConverter.toEntity(dto.getContactDTO()));
        PersonEntity person = new PersonEntity();
        UsersEntity entity = usersEntityPostConverter.toEntity(dto);
        person.setIndividual(entity.getIndividual());
        person.getIndividual().setUsersEntity(entity);
        person.setContacts(contacts);
        person.getIndividual().getUsersEntity().setCompanySystem(companySystemRepository.
                findByIdCompanySystem(dto.getCompanySystem().getIdCompanySystem()));
        personRepository.save(person);
    }

    public void postChangePassword(UsersEntity entity){
        usersRepository.save(entity);
    }

    /**
     * Method for setting up Contact object within user
     */
    private void buildContactToUsers(UsersEntity entity, UsersDTO dto) {
        try {
            if (entity.getIndividual().getPersonEntity().getContacts() != null) {
                dto.setContact(contactEntityConverter.toDTO(entity.getIndividual().getPersonEntity()
                        .getContacts().get(0)));
            }
        }catch (NullPointerException ne) {
            throw new HttpBadRequestException(USUARIO_SEM_CONTATO);
        }
    }

    /**
     * Update a User
     */
    public void putUsers(UsersDTO dto) {
        UsersEntity user = usersRepository.findByUsername(dto.getUsername());
        validationUsersToPut(dto, user);
        validationIndividualToPut(dto, user);
        validationContactToPut(dto);
        usersRepository.save(user);
    }

    /**
     * Method that validates if an User can be updated
     */
    private void validationUsersToPut(UsersDTO dto, UsersEntity user) {
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
    }

    /**
     * Method that validates if an Contact can be updated
     */
    private void validationContactToPut(UsersDTO dto) {
        if (dto.getContact() != null){
            ContactEntity contact = contactRepository.findByIdContact(dto.getContact().getIdContact());
            if (dto.getContact().getCellwhats() != null){
                contact.setCellwhats(dto.getContact().getCellwhats());
            }
            if (!dto.getContact().getCellPhone().isEmpty() || dto.getContact().getCellPhone() != null){
                contact.setCellPhone(dto.getContact().getCellPhone());
            }
            if (!dto.getContact().getEmail().isEmpty() || dto.getContact().getEmail() != null){
                contact.setEmail(dto.getContact().getEmail());
            }
            if (!dto.getContact().getPhone().isEmpty() || dto.getContact().getPhone() != null){
                contact.setPhone(dto.getContact().getPhone());
            }
            contactRepository.save(contact);
        }
    }

    /**
     * Method that validates if an Individual can be updated
     */
    private void validationIndividualToPut(UsersDTO dto, UsersEntity user) {
        if (dto.getIndividual() != null){
            if (user.getIndividual() == null)
                user.setIndividual(new IndividualEntity());
            if (dto.getIndividual().getIdIndividual() != null) {
                user.getIndividual().setIdIndividual(dto.getIndividual().getIdIndividual());
            }
            if (!dto.getIndividual().getCpf().isEmpty() || dto.getIndividual().getCpf() != null) {
                user.getIndividual().setCpf(dto.getIndividual().getCpf());
            }
            if (dto.getIndividual().getActive() != null) {
                user.getIndividual().setActive(dto.getIndividual().getActive());
            }
            if (!dto.getIndividual().getNameIndividual().isEmpty() || dto.getIndividual().getNameIndividual() != null) {
                user.getIndividual().setNameIndividual(dto.getIndividual().getNameIndividual());
            }
            if (!dto.getIndividual().getRg().isEmpty() || dto.getIndividual().getRg() != null) {
                user.getIndividual().setRg(dto.getIndividual().getRg());
            }
            if (!dto.getIndividual().getLastName().isEmpty() || dto.getIndividual().getLastName() != null) {
                user.getIndividual().setLastName(dto.getIndividual().getLastName());
            }
            if (dto.getIndividual().getBirthDate() != null) {
                user.getIndividual().setBirthDate(dto.getIndividual().getBirthDate());
            }
        }
    }

    /**
     * Validates that the password change code is valid
     */
    public UsersEntity getUserChangePass(String code) {
        UsersEntity user = usersRepository.findByCode(code);
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
