package com.unicesumar.ads.tcc.converter.vehicle;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.VehicleEntity;
import com.unicesumar.ads.tcc.dto.VehicleDTO;
import com.unicesumar.ads.tcc.dto.vehiclePostDTO.VehiclePostDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehiclePostEntityConverter extends DTOEntityConverter<VehiclePostDTO, VehicleEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected VehiclePostDTO toDTOImp(VehicleEntity entity){
        return mapperUtil.use().map(entity, VehiclePostDTO.class);
    }

    @Override
    protected VehicleEntity toEntityImp(VehiclePostDTO dto){
        return mapperUtil.use().map(dto, VehicleEntity.class);
    }

}