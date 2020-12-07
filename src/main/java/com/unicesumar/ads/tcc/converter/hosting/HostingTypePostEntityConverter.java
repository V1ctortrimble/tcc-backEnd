package com.unicesumar.ads.tcc.converter.hosting;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.HostingTypeEntity;
import com.unicesumar.ads.tcc.dto.hostingPostDTO.HostingTypePostDTO;
import com.unicesumar.ads.tcc.dto.hostingPutDTO.HostingTypePutDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HostingTypePostEntityConverter extends DTOEntityConverter<HostingTypePostDTO, HostingTypeEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected HostingTypePostDTO toDTOImp(HostingTypeEntity entity){
        return mapperUtil.use().map(entity, HostingTypePostDTO.class);
    }
    @Override
    protected HostingTypeEntity toEntityImp(HostingTypePostDTO dto){
        return mapperUtil.use().map(dto, HostingTypeEntity.class);
    }

}