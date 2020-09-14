package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.TravelPackgeDTO;
import com.unicesumar.ads.tcc.entity.TravelPackgeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TravelPackgeEntityConverter extends DTOEntityConverter<TravelPackgeDTO, TravelPackgeEntity>{

    private final MapperUtil mapperUtil;

    @Override
    protected TravelPackgeDTO toDTOImp(TravelPackgeEntity entity){
        return mapperUtil.use().map(entity, TravelPackgeDTO.class);
    }

    @Override
    protected TravelPackgeEntity toEntityImp(TravelPackgeDTO dto){
        return mapperUtil.use().map(dto, TravelPackgeEntity.class);
    }

}