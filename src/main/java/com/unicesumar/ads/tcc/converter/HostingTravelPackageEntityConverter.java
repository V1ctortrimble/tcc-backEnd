package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.HostingTravelPackageDTO;
import com.unicesumar.ads.tcc.entity.HostingTravelPackageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HostingTravelPackageEntityConverter extends DTOEntityConverter<HostingTravelPackageDTO, HostingTravelPackageEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected HostingTravelPackageDTO toDTOImp(HostingTravelPackageEntity entity){
        return mapperUtil.use().map(entity, HostingTravelPackageDTO.class);
    }

    @Override
    protected HostingTravelPackageEntity toEntityImp(HostingTravelPackageDTO dto){
        return mapperUtil.use().map(dto, HostingTravelPackageEntity.class);
    }

}