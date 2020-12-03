package com.unicesumar.ads.tcc.converter.travelPackage;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.TravelPackageEntity;
import com.unicesumar.ads.tcc.dto.TravelPackageDTO;
import com.unicesumar.ads.tcc.dto.travelPackagePostDTO.TravelPackagePostDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TravelPackagePostEntityConverter extends DTOEntityConverter<TravelPackagePostDTO, TravelPackageEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected TravelPackagePostDTO toDTOImp(TravelPackageEntity entity){
        return mapperUtil.use().map(entity, TravelPackagePostDTO.class);
    }

    @Override
    protected TravelPackageEntity toEntityImp(TravelPackagePostDTO dto){
        return mapperUtil.use().map(dto, TravelPackageEntity.class);
    }

}