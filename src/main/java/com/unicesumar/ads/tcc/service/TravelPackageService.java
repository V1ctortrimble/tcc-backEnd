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

    public List<TravelPackageEntity> getTravelPackage() {
        return travelPackageRepository.findAll();
    }

    public Page<TravelPackageEntity> getTravelPackageFilter(Integer idTravelPackge, Optional<String> nameTravelPackge,
                                                         Optional<String> originName,
                                                         Optional<String> destinationName,
                                                         Boolean active,
                                                         Pageable pageable) {

        nameTravelPackge = validationTravelNameIsEmpty(nameTravelPackge);
        originName = validationOriginNameIsEmpty(originName);
        destinationName = validationDestinationNameIsEmpty(destinationName);
        return getIndividualByFilters(idTravelPackge, nameTravelPackge, originName, destinationName, active, pageable);
    }


    /**
     * Select find according to parameters passed in the URL
     */
    private Page<TravelPackageEntity> getIndividualByFilters(Integer idTravelPackge, Optional<String> nameTravelPackge,
                                                          Optional<String> originName,
                                                          Optional<String> destinationName,
                                                          Boolean active,
                                                          Pageable pageable) {
        if(idTravelPackge!=null && nameTravelPackge.isPresent()) {
            return travelPackageRepository.findByIdTravelPackgeAndNameTravelPackgeIgnoreCaseContainingAndActive(idTravelPackge, nameTravelPackge, active, pageable);
        }
        if(idTravelPackge!=null  && destinationName.isPresent()) {
            return travelPackageRepository.findByIdTravelPackgeAndDestinationNameIgnoreCaseContainingAndActive(idTravelPackge, destinationName, active, pageable);
        }
        if(idTravelPackge!=null ) {
            return travelPackageRepository.findByIdTravelPackgeAndActive(idTravelPackge, active, pageable);
        }
        if (nameTravelPackge.isPresent() && destinationName.isPresent()) {
            return travelPackageRepository.findByNameTravelPackgeIgnoreCaseContainingAndDestinationNameIgnoreCaseContainingAndActive(nameTravelPackge,
                    destinationName, active, pageable);
        }
        if (nameTravelPackge.isPresent() && originName.isPresent()){
            return travelPackageRepository.findByNameTravelPackgeIgnoreCaseContainingAndOriginNameIgnoreCaseContainingAndActive(nameTravelPackge, originName, active, pageable);
        }
        if (nameTravelPackge.isPresent()){
            return travelPackageRepository.findByNameTravelPackgeIgnoreCaseContainingAndActive(nameTravelPackge, active, pageable);
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
