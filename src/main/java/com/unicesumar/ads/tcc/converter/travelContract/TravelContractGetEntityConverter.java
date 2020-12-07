package com.unicesumar.ads.tcc.converter.travelContract;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.TravelContractEntity;
import com.unicesumar.ads.tcc.dto.TravelContractGetDTO.TravelContractGetDTO;
import com.unicesumar.ads.tcc.dto.travelContractPostDTO.TravelContractPostDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TravelContractGetEntityConverter extends DTOEntityConverter<TravelContractGetDTO, TravelContractEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected TravelContractGetDTO toDTOImp(TravelContractEntity entity){
        return mapperUtil.use().map(entity, TravelContractGetDTO.class);
    }
    @Override
    protected TravelContractEntity toEntityImp(TravelContractGetDTO dto){
        return mapperUtil.use().map(dto, TravelContractEntity.class);
    }

}