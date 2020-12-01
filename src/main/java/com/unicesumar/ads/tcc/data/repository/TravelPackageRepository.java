package com.unicesumar.ads.tcc.data.repository;

import com.unicesumar.ads.tcc.data.entity.TravelPackageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackageEntity, Integer> {

    Page<TravelPackageEntity> findAllByActive(Boolean active, Pageable pageable);
    Page<TravelPackageEntity> findByIdTravelPackgeAndActive(Integer idTravelPackge,Boolean active, Pageable pageable);
    Page<TravelPackageEntity> findByIdTravelPackgeAndNameTravelPackgeIgnoreCaseContainingAndActive(Integer idTravelPackge,
                                                                                                 Optional<String> nameTravelPackge,
                                                                                                 Boolean active,
                                                                                                 Pageable pageable);
    Page<TravelPackageEntity> findByIdTravelPackgeAndDestinationNameIgnoreCaseContainingAndActive(Integer idTravelPackge,
                                                                                                  Optional<String> destinationName,
                                                                                                  Boolean active,
                                                                                                  Pageable pageable);
    Page<TravelPackageEntity> findByNameTravelPackgeIgnoreCaseContainingAndDestinationNameIgnoreCaseContainingAndActive(Optional<String> nameTravelPackge,
                                                                                                                        Optional<String> destinationName,
                                                                                                                        Boolean active,
                                                                                                                        Pageable pageable);
    Page<TravelPackageEntity> findByNameTravelPackgeIgnoreCaseContainingAndOriginNameIgnoreCaseContainingAndActive(Optional<String> nameTravelPackge,
                                                                                                                   Optional<String> originName,
                                                                                                                   Boolean active,
                                                                                                                   Pageable pageable);
    Page<TravelPackageEntity> findByNameTravelPackgeIgnoreCaseContainingAndActive(Optional<String> nameTravelPackge,
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