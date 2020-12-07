package com.unicesumar.ads.tcc.converter.vehicle;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.VehicleTypeEntity;
import com.unicesumar.ads.tcc.dto.vehicleGetDTO.VehicleTypeGetDTO;
import com.unicesumar.ads.tcc.dto.vehiclePutDTO.VehicleTypePutDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleTypePutEntityConverter extends DTOEntityConverter<VehicleTypePutDTO, VehicleTypeEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected VehicleTypePutDTO toDTOImp(VehicleTypeEntity entity){
        return mapperUtil.use().map(entity, VehicleTypePutDTO.class);
    }

    @Override
    protected VehicleTypeEntity toEntityImp(VehicleTypePutDTO dto){
        return mapperUtil.use().map(dto, VehicleTypeEntity.class);
    }

}