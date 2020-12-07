package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

    UsersEntity findByUsername(String username);
    UsersEntity findByCode(String code);
    Page<UsersEntity> findAllByActive(Boolean active, Pageable pageable);
    Page<UsersEntity> findByUsernameIgnoreCaseContainingAndActive(Optional<String> username, Boolean active,
                                                                  Pageable pageable);
    Page<UsersEntity> findByUsernameIgnoreCaseContainingAndIndividualNameIndividualIgnoreCaseContainingAndAndActive(Optional<String> username,
                                                                                                                    Optional<String>name, Boolean active,
                                                                                                                    Pageable pageable);
    Page<UsersEntity> findByUsernameIgnoreCaseContainingAndIndividualLastNameIgnoreCaseContainingAndActive(Optional<String> username,
                                                                                                           Optional<String> lastName, Boolean active,
                                                                                                           Pageable pageable);
    Page<UsersEntity> findByIndividualNameIndividualIgnoreCaseContainingAndActive(Optional<String> name,
                                                                                  Boolean active,
                                                                                  Pageable pageable);
    Page<UsersEntity> findByIndividualLastNameIgnoreCaseContainingAndActive(Optional<String> lastName,
                                                                            Boolean active,
                                                                            Pageable pageable);
    Page<UsersEntity> findByIndividualNameIndividualIgnoreCaseContainingAndIndividualLastNameIgnoreCaseContainingAndActive(Optional<String> name,
                                                                                                                           Optional<String> lastName,
                                                                                                                           Boolean active,
                                                                                                                           Pageable pageable);
    Page<UsersEntity> findByIndividualCpfAndActive(Optional<String> cpf, Boolean active, Pageable pageable);
    Page<UsersEntity> findByIndividualCpfAndIndividualNameIndividualIgnoreCaseContainingAndActive(Optional<String> cpf,
                                                                                                  Optional<String> name,
                                                                                                  Boolean active,
                                                                                                  Pageable pageable);
    Page<UsersEntity> findByIndividualCpfAndIndividualLastNameIgnoreCaseContainingAndActive(Optional<String> cpf,
                                                                                            Optional<String> lastName,
                                                                                            Boolean active,
                                                                                            Pageable pageable);
    Page<UsersEntity> findByIndividualCpfAndIndividualNameIndividualIgnoreCaseContainingAndIndividualLastNameIgnoreCaseContainingAndActive(Optional<String> cpf,
                                                                                                                                           Optional<String> name,
                                                                                                                                           Optional<String> lastName,
                                                                                                                                           Boolean active, Pageable pageable);
}