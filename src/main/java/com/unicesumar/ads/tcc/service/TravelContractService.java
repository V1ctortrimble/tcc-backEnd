package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.TravelContractEntity;
import com.unicesumar.ads.tcc.data.repository.TravelContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelContractService {

    private final TravelContractRepository travelContractRepository;

    public TravelContractEntity postTravelContract(TravelContractEntity entity){
        return travelContractRepository.save(entity);
    }

    public List<TravelContractEntity> getAllTravelContracts(){
        return travelContractRepository.findAll();
    }

    public TravelContractEntity getTravelContractById(Integer id) { return travelContractRepository.getOne(id); }
}
