package com.unicesumar.ads.tcc.converter.vehicle;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.VehicleEntity;
import com.unicesumar.ads.tcc.dto.vehicleGetDTO.VehicleGetDTO;
import com.unicesumar.ads.tcc.dto.vehiclePutDTO.VehiclePutDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleGetEntityConverter extends DTOEntityConverter<VehicleGetDTO, VehicleEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected VehicleGetDTO toDTOImp(VehicleEntity entity){
        return mapperUtil.use().map(entity, VehicleGetDTO.class);
    }

    @Override
    protected VehicleEntity toEntityImp(VehicleGetDTO dto){
        return mapperUtil.use().map(dto, VehicleEntity.class);
    }

}