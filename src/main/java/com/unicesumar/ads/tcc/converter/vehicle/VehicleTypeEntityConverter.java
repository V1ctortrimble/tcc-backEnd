package com.unicesumar.ads.tcc.converter.vehicle;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.VehicleTypeEntity;
import com.unicesumar.ads.tcc.dto.VehicleTypeDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleTypeEntityConverter extends DTOEntityConverter<VehicleTypeDTO, VehicleTypeEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected VehicleTypeDTO toDTOImp(VehicleTypeEntity entity){
        return mapperUtil.use().map(entity, VehicleTypeDTO.class);
    }

    @Override
    protected VehicleTypeEntity toEntityImp(VehicleTypeDTO dto){
        return mapperUtil.use().map(dto, VehicleTypeEntity.class);
    }

}