package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.TravelPackageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackageEntity, Integer> {

    TravelPackageEntity findByIdTravelPackage(Integer idTravelPackage);
    Page<TravelPackageEntity> findAllByActive(Boolean active, Pageable pageable);
    Page<TravelPackageEntity> findByIdTravelPackageAndActive(Integer idTravelPackage,Boolean active, Pageable pageable);
    Page<TravelPackageEntity> findByIdTravelPackageAndNameTravelPackageIgnoreCaseContainingAndActive(Integer idTravelPackage,
                                                                                                 Optional<String> nameTravelPackage,
                                                                                                 Boolean active,
                                                                                                 Pageable pageable);
    Page<TravelPackageEntity> findByIdTravelPackageAndDestinationNameIgnoreCaseContainingAndActive(Integer idTravelPackage,
                                                                                                  Optional<String> destinationName,
                                                                                                  Boolean active,
                                                                                                  Pageable pageable);
    Page<TravelPackageEntity> findByNameTravelPackageIgnoreCaseContainingAndDestinationNameIgnoreCaseContainingAndActive(Optional<String> nameTravelPackage,
                                                                                                                        Optional<String> destinationName,
                                                                                                                        Boolean active,
                                                                                                                        Pageable pageable);
    Page<TravelPackageEntity> findByNameTravelPackageIgnoreCaseContainingAndOriginNameIgnoreCaseContainingAndActive(Optional<String> nameTravelPackage,
                                                                                                                   Optional<String> originName,
                                                                                                                   Boolean active,
                                                                                                                   Pageable pageable);
    Page<TravelPackageEntity> findByNameTravelPackageIgnoreCaseContainingAndActive(Optional<String> nameTravelPackage,
                                                                                  Boolean active,
                                                                                  Pageable pageable);
    Page<TravelPackageEntity> findByDestinationNameIgnoreCaseContainingAndOriginNameIgnoreCaseContainingAndActive(Optional<String> destinationName,
                                                                                                                  Optional<String> originName,
                                                                                                                  Boolean active,
                                                                                                                  Pageable pageable);
    Page<TravelPackageEntity> findByDestinationNameIgnoreCaseContainingAndActive(Optional<String> destinationName,
                                                                                 Boolean active, Pageable pageable);
    Page<TravelPackageEntity> findByOriginNameIgnoreCaseContainingAndActive(Optional<String> originName, Boolean active,
                                                                            Pageable pageable);
}