package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.VehicleTypeEntity;
import com.unicesumar.ads.tcc.dto.VehicleTypeDTO;
import com.unicesumar.ads.tcc.dto.vehiclePostDTO.VehicleTypePostDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleTypePostEntityConverter extends DTOEntityConverter<VehicleTypePostDTO, VehicleTypeEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected VehicleTypePostDTO toDTOImp(VehicleTypeEntity entity){
        return mapperUtil.use().map(entity, VehicleTypePostDTO.class);
    }

    @Override
    protected VehicleTypeEntity toEntityImp(VehicleTypePostDTO dto){
        return mapperUtil.use().map(dto, VehicleTypeEntity.class);
    }

}