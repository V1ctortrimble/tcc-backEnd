package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.VehicleDTO;
import com.unicesumar.ads.tcc.data.entity.VehicleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleEntityConverter extends DTOEntityConverter<VehicleDTO, VehicleEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected VehicleDTO toDTOImp(VehicleEntity entity){
        return mapperUtil.use().map(entity, VehicleDTO.class);
    }

    @Override
    protected VehicleEntity toEntityImp(VehicleDTO dto){
        return mapperUtil.use().map(dto, VehicleEntity.class);
    }

}