package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.TravelPackageEntity;
import com.unicesumar.ads.tcc.data.repository.TravelPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TravelPackageService {

    private final TravelPackageRepository travelPackageRepository;

    public void postTravelPackage(TravelPackageEntity entity){
        travelPackageRepository.save(entity);
    }

    public List<TravelPackageEntity> getTravelPackage() {
        return travelPackageRepository.findAll();
    }

    public TravelPackageEntity getTravelPackageById(Integer idTravelPackage) {
        return travelPackageRepository.findByIdTravelPackage(idTravelPackage);
    }

    public Page<TravelPackageEntity> getTravelPackageFilter(Integer idTravelPackage, Optional<String> nameTravelPackage,
                                                         Optional<String> originName,
                                                         Optional<String> destinationName,
                                                         Boolean active,
                                                         Pageable pageable) {

        nameTravelPackage = validationTravelNameIsEmpty(nameTravelPackage);
        originName = validationOriginNameIsEmpty(originName);
        destinationName = validationDestinationNameIsEmpty(destinationName);
        return getIndividualByFilters(idTravelPackage, nameTravelPackage, originName, destinationName, active, pageable);
    }


    /**
     * Select find according to parameters passed in the URL
     */
    private Page<TravelPackageEntity> getIndividualByFilters(Integer idTravelPackge, Optional<String> nameTravelPackage,
                                                          Optional<String> originName,
                                                          Optional<String> destinationName,
                                                          Boolean active,
                                                          Pageable pageable) {
        if(idTravelPackge!=null && nameTravelPackage.isPresent()) {
            return travelPackageRepository.findByIdTravelPackageAndNameTravelPackageIgnoreCaseContainingAndActive(idTravelPackge, nameTravelPackage, active, pageable);
        }
        if(idTravelPackge!=null  && destinationName.isPresent()) {
            return travelPackageRepository.findByIdTravelPackageAndDestinationNameIgnoreCaseContainingAndActive(idTravelPackge, destinationName, active, pageable);
        }
        if(idTravelPackge!=null ) {
            return travelPackageRepository.findByIdTravelPackageAndActive(idTravelPackge, active, pageable);
        }
        if (nameTravelPackage.isPresent() && destinationName.isPresent()) {
            return travelPackageRepository.findByNameTravelPackageIgnoreCaseContainingAndDestinationNameIgnoreCaseContainingAndActive(nameTravelPackage,
                    destinationName, active, pageable);
        }
        if (nameTravelPackage.isPresent() && originName.isPresent()){
            return travelPackageRepository.findByNameTravelPackageIgnoreCaseContainingAndOriginNameIgnoreCaseContainingAndActive(nameTravelPackage, originName, active, pageable);
        }
        if (nameTravelPackage.isPresent()){
            return travelPackageRepository.findByNameTravelPackageIgnoreCaseContainingAndActive(nameTravelPackage, active, pageable);
        }
        if (destinationName.isPresent() && originName.isPresent()) {
            return travelPackageRepository.findByDestinationNameIgnoreCaseContainingAndOriginNameIgnoreCaseContainingAndActive(destinationName,originName, active, pageable);
        }
        if (destinationName.isPresent()) {
            return travelPackageRepository.findByDestinationNameIgnoreCaseContainingAndActive(destinationName, active, pageable);
        }
        if (originName.isPresent()) {
            return travelPackageRepository.findByOriginNameIgnoreCaseContainingAndActive(originName, active, pageable);
        }
        return travelPackageRepository.findAllByActive(active, pageable);
    }



    /**
     * Method that validates if an empty string in travelName
     */
    private Optional<String> validationTravelNameIsEmpty(Optional<String> nameTravelPackge) {
        if (nameTravelPackge.isPresent() && nameTravelPackge.get().equals("")) {
            nameTravelPackge = Optional.empty();
        }
        return nameTravelPackge;
    }

    /**
     * Method that validates if an empty string in destinationName
     */
    private Optional<String> validationDestinationNameIsEmpty(Optional<String> destinationName) {
        if (destinationName.isPresent() && destinationName.get().equals("")) {
            destinationName = Optional.empty();
        }
        return destinationName;
    }

    /**
     * Method that validates if an empty string in originName
     */
    private Optional<String> validationOriginNameIsEmpty(Optional<String> originName) {
        if (originName.isPresent() && originName.get().equals("")) {
            originName = Optional.empty();
        }
        return originName;
    }

}
