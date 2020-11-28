package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.TravelPackageEntity;
import com.unicesumar.ads.tcc.data.repository.TravelPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelPackageService {

    private final TravelPackageRepository travelPackageRepository;

    public List<TravelPackageEntity> getTravelPackage() {
        return travelPackageRepository.findAll();
    }
}
