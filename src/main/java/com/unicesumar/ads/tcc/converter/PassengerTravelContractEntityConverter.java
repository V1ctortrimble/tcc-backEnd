package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.PassengerTravelContractDTO;
import com.unicesumar.ads.tcc.data.entity.PassengerTravelContractEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PassengerTravelContractEntityConverter extends DTOEntityConverter<PassengerTravelContractDTO, PassengerTravelContractEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected com.unicesumar.ads.tcc.dto.PassengerTravelContractDTO toDTOImp(PassengerTravelContractEntity entity){
        return mapperUtil.use().map(entity, com.unicesumar.ads.tcc.dto.PassengerTravelContractDTO.class);
    }

    @Override
    protected PassengerTravelContractEntity toEntityImp(com.unicesumar.ads.tcc.dto.PassengerTravelContractDTO dto){
        return mapperUtil.use().map(dto, PassengerTravelContractEntity.class);
    }

}