package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.PassengerTravelContractDTO;
import com.unicesumar.ads.tcc.entity.PassengerTravelContractEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PassengerTravelContractEntityConverter extends DTOEntityConverter<PassengerTravelContractDTO, PassengerTravelContractEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PassengerTravelContractDTO toDTOImp(PassengerTravelContractEntity entity){
        return mapperUtil.use().map(entity, PassengerTravelContractDTO.class);
    }

    @Override
    protected PassengerTravelContractEntity toEntityImp(PassengerTravelContractDTO dto){
        return mapperUtil.use().map(dto, PassengerTravelContractEntity.class);
    }

}