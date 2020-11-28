package com.unicesumar.ads.tcc.converter.vehicle;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.VehicleEntity;
import com.unicesumar.ads.tcc.data.entity.VehicleTypeEntity;
import com.unicesumar.ads.tcc.dto.vehicleGetDTO.VehicleGetDTO;
import com.unicesumar.ads.tcc.dto.vehicleGetDTO.VehicleTypeGetDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleTypeGetEntityConverter extends DTOEntityConverter<VehicleTypeGetDTO, VehicleTypeEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected VehicleTypeGetDTO toDTOImp(VehicleTypeEntity entity){
        return mapperUtil.use().map(entity, VehicleTypeGetDTO.class);
    }

    @Override
    protected VehicleTypeEntity toEntityImp(VehicleTypeGetDTO dto){
        return mapperUtil.use().map(dto, VehicleTypeEntity.class);
    }

}