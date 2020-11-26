package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.HostingEntity;
import com.unicesumar.ads.tcc.data.repository.HostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HostingService {
    private final HostingRepository hostingRepository;

    public void postHost(HostingEntity entity){
        hostingRepository.save(entity);
    }

    public List<HostingEntity> getAllByCnpj(String cnpj){
        return hostingRepository.findAllByPersonCompanyCnpj(cnpj);
    }

    public List<HostingEntity> getAllByCpf(String cpf){
        return hostingRepository.findAllByPersonCompanyCnpj(cpf);
    }
}
