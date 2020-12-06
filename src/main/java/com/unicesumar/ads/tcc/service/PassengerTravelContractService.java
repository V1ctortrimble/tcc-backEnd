package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.converter.travelContract.PassengerTravelContractPostEntityConverter;
import com.unicesumar.ads.tcc.data.entity.PassengerTravelContractEntity;
import com.unicesumar.ads.tcc.data.repository.PassengerTravelContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerTravelContractService {

    private final PassengerTravelContractRepository passengerTravelContractRepository;

    public PassengerTravelContractEntity postPassengerTravelContract(PassengerTravelContractEntity entity){
        return passengerTravelContractRepository.save(entity);
    }

    public PassengerTravelContractEntity getById(Integer id){
        return passengerTravelContractRepository.findByIdPassengerTravelContract(id);
    }

    public PassengerTravelContractEntity getValidation(Integer idIndividual, Integer idTravelContract){
        return passengerTravelContractRepository.findByIndividualIdIndividualAndTravelContractIdTravelContract(idIndividual, idTravelContract);
    }

    public PassengerTravelContractEntity getValidationPackage(Integer idIndividual, Integer idTravelPackage){
        return passengerTravelContractRepository.findByIndividualIdIndividualAndTravelContractTravelPackageIdTravelPackage(idIndividual, idTravelPackage);
    }
}
