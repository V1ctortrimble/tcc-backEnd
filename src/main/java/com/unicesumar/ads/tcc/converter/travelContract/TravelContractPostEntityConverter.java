package com.unicesumar.ads.tcc.converter.travelContract;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.TravelContractEntity;
import com.unicesumar.ads.tcc.dto.TravelContractDTO;
import com.unicesumar.ads.tcc.dto.travelContractPostDTO.TravelContractPostDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TravelContractPostEntityConverter extends DTOEntityConverter<TravelContractPostDTO, TravelContractEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected TravelContractPostDTO toDTOImp(TravelContractEntity entity){
        return mapperUtil.use().map(entity, TravelContractPostDTO.class);
    }
    @Override
    protected TravelContractEntity toEntityImp(TravelContractPostDTO dto){
        return mapperUtil.use().map(dto, TravelContractEntity.class);
    }

}