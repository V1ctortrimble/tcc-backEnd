package com.unicesumar.ads.tcc.converter.travelContract;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.PassengerTravelContractEntity;
import com.unicesumar.ads.tcc.dto.PassengerTravelContractDTO;
import com.unicesumar.ads.tcc.dto.travelContractPostDTO.PassengerTravelContractPostDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PassengerTravelContractPostEntityConverter extends DTOEntityConverter<PassengerTravelContractPostDTO, PassengerTravelContractEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PassengerTravelContractPostDTO toDTOImp(PassengerTravelContractEntity entity){
        return mapperUtil.use().map(entity, PassengerTravelContractPostDTO.class);
    }

    @Override
    protected PassengerTravelContractEntity toEntityImp(PassengerTravelContractPostDTO dto){
        return mapperUtil.use().map(dto, PassengerTravelContractEntity.class);
    }

}