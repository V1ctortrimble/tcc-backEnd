package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.HostingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostingRepository extends JpaRepository<HostingEntity, Integer> {
    List<HostingEntity> findAllByPersonIndividualCpf(String cpf);
    List<HostingEntity> findAllByPersonCompanyCnpj(String cnpj);
}