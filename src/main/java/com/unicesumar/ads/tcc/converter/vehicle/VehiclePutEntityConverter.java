package com.unicesumar.ads.tcc.converter.vehicle;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.VehicleEntity;
import com.unicesumar.ads.tcc.dto.VehicleDTO;
import com.unicesumar.ads.tcc.dto.vehiclePutDTO.VehiclePutDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehiclePutEntityConverter extends DTOEntityConverter<VehiclePutDTO, VehicleEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected VehiclePutDTO toDTOImp(VehicleEntity entity){
        return mapperUtil.use().map(entity, VehiclePutDTO.class);
    }

    @Override
    protected VehicleEntity toEntityImp(VehiclePutDTO dto){
        return mapperUtil.use().map(dto, VehicleEntity.class);
    }

}