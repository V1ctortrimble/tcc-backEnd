package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.HostingTypeEntity;
import com.unicesumar.ads.tcc.dto.HostingTypeDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HostingTypeEntityConverter extends DTOEntityConverter<HostingTypeDTO, HostingTypeEntity>{

    private final MapperUtil mapperUtil;

    @Override
    protected HostingTypeDTO toDTOImp(HostingTypeEntity entity){
        return mapperUtil.use().map(entity, HostingTypeDTO.class);
    }
    @Override
    protected HostingTypeEntity toEntityImp(HostingTypeDTO dto){
        return mapperUtil.use().map(dto, HostingTypeEntity.class);
    }

}