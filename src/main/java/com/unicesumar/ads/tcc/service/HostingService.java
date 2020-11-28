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

    /**
     * Save or update Hosting
     */
    public void postHosting(HostingEntity entity){
        hostingRepository.save(entity);
    }

    /**
     * Find Hosting By cnpj
     */
    public List<HostingEntity> getAllHostingsByCnpj(String cnpj, Boolean active){
        return hostingRepository.findAllByActiveAndPersonCompanyCnpj(active,cnpj);
    }
}
