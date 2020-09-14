package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.HostingDTO;
import com.unicesumar.ads.tcc.entity.HostingEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HostingEntityConverter extends DTOEntityConverter<HostingDTO, HostingEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected HostingDTO toDTOImp(HostingEntity entity){
        return mapperUtil.use().map(entity, HostingDTO.class);
    }

    @Override
    protected HostingEntity toEntityImp(HostingDTO dto){
        return mapperUtil.use().map(dto, HostingEntity.class);
    }

}