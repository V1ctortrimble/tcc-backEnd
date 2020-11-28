package com.unicesumar.ads.tcc.converter.hosting;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.HostingEntity;
import com.unicesumar.ads.tcc.dto.hostingPostDTO.HostingPostDTO;
import com.unicesumar.ads.tcc.dto.hostingPutDTO.HostingPutDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HostingPutEntityConverter extends DTOEntityConverter<HostingPutDTO, HostingEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected HostingPutDTO toDTOImp(HostingEntity entity){
        return mapperUtil.use().map(entity, HostingPutDTO.class);
    }

    @Override
    protected HostingEntity toEntityImp(HostingPutDTO dto){
        return mapperUtil.use().map(dto, HostingEntity.class);
    }

}