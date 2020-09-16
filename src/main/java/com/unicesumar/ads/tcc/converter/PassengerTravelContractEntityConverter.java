package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.entity.PassengerTravelContractDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PassengerTravelContractEntityConverter extends DTOEntityConverter<com.unicesumar.ads.tcc.dto.PassengerTravelContractDTO, PassengerTravelContractDTO> {

    private final MapperUtil mapperUtil;

    @Override
    protected com.unicesumar.ads.tcc.dto.PassengerTravelContractDTO toDTOImp(PassengerTravelContractDTO entity){
        return mapperUtil.use().map(entity, com.unicesumar.ads.tcc.dto.PassengerTravelContractDTO.class);
    }

    @Override
    protected PassengerTravelContractDTO toEntityImp(com.unicesumar.ads.tcc.dto.PassengerTravelContractDTO dto){
        return mapperUtil.use().map(dto, PassengerTravelContractDTO.class);
    }

}