package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.HostingEntity;
import com.unicesumar.ads.tcc.data.entity.HostingTypeEntity;
import com.unicesumar.ads.tcc.data.repository.HostingRepository;
import com.unicesumar.ads.tcc.data.repository.HostingTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HostingService {

    private final HostingRepository hostingRepository;
    private final HostingTypeRepository hostingTypeRepository;

    /**
     * Save or update Hosting
     */
    public void postHosting(HostingEntity entity){
        hostingRepository.save(entity);
    }

    public List<HostingEntity> getAllHostings(Boolean active){
        return hostingRepository.findAllByActive(active);
    }

    /**
     * Find Hosting By cnpj
     */
    public List<HostingEntity> getAllHostingsByCnpj(String cnpj, Boolean active){
        return hostingRepository.findAllByActiveAndPersonCompanyCnpj(active,cnpj);
    }
    /**
     * Find Hosting By id
     */
    public HostingEntity getHostingById(Integer id){
        return hostingRepository.getOne(id);
    }

    public List<HostingTypeEntity> getAllHostingType(){
       return hostingTypeRepository.findAll();
    }

    /**
     * Save or update Hosting
     */
    public void postHostingType(HostingTypeEntity entity){
        hostingTypeRepository.save(entity);
    }
}
