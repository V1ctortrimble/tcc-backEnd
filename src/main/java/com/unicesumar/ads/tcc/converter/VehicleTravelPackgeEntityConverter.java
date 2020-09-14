package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.VehicleTravelPackgeDTO;
import com.unicesumar.ads.tcc.entity.VehicleTravelPackgeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleTravelPackgeEntityConverter extends DTOEntityConverter<VehicleTravelPackgeDTO, VehicleTravelPackgeEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected VehicleTravelPackgeDTO toDTOImp(VehicleTravelPackgeEntity entity){
        return mapperUtil.use().map(entity, VehicleTravelPackgeDTO.class);
    }

    @Override
    protected VehicleTravelPackgeEntity toEntityImp(VehicleTravelPackgeDTO dto){
        return mapperUtil.use().map(dto, VehicleTravelPackgeEntity.class);
    }

}