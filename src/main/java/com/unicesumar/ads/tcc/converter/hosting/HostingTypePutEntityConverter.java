package com.unicesumar.ads.tcc.converter.hosting;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.HostingTypeEntity;
import com.unicesumar.ads.tcc.dto.HostingTypeDTO;
import com.unicesumar.ads.tcc.dto.hostingPutDTO.HostingTypePutDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HostingTypePutEntityConverter extends DTOEntityConverter<HostingTypePutDTO, HostingTypeEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected HostingTypePutDTO toDTOImp(HostingTypeEntity entity){
        return mapperUtil.use().map(entity, HostingTypePutDTO.class);
    }
    @Override
    protected HostingTypeEntity toEntityImp(HostingTypePutDTO dto){
        return mapperUtil.use().map(dto, HostingTypeEntity.class);
    }

}