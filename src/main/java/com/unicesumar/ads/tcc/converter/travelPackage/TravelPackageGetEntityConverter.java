package com.unicesumar.ads.tcc.converter.travelPackage;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.TravelPackageEntity;
import com.unicesumar.ads.tcc.dto.travelPackagePostDTO.TravelPackageGetDTO;
import com.unicesumar.ads.tcc.dto.travelPackagePostDTO.TravelPackagePostDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TravelPackageGetEntityConverter extends DTOEntityConverter<TravelPackageGetDTO, TravelPackageEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected TravelPackageGetDTO toDTOImp(TravelPackageEntity entity){
        return mapperUtil.use().map(entity, TravelPackageGetDTO.class);
    }

    @Override
    protected TravelPackageEntity toEntityImp(TravelPackageGetDTO dto){
        return mapperUtil.use().map(dto, TravelPackageEntity.class);
    }

}