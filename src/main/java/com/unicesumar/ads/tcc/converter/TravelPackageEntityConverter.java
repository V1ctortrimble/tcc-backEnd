package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.TravelPackageEntity;
import com.unicesumar.ads.tcc.dto.TravelPackageDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TravelPackageEntityConverter extends DTOEntityConverter<TravelPackageDTO, TravelPackageEntity>{

    private final MapperUtil mapperUtil;

    @Override
    protected TravelPackageDTO toDTOImp(TravelPackageEntity entity){
        return mapperUtil.use().map(entity, TravelPackageDTO.class);
    }

    @Override
    protected TravelPackageEntity toEntityImp(TravelPackageDTO dto){
        return mapperUtil.use().map(dto, TravelPackageEntity.class);
    }

}