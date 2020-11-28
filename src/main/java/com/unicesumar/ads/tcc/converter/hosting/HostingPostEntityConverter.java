package com.unicesumar.ads.tcc.converter.hosting;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.HostingEntity;
import com.unicesumar.ads.tcc.dto.HostingDTO;
import com.unicesumar.ads.tcc.dto.hostingPostDTO.HostingPostDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HostingPostEntityConverter extends DTOEntityConverter<HostingPostDTO, HostingEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected HostingPostDTO toDTOImp(HostingEntity entity){
        return mapperUtil.use().map(entity, HostingPostDTO.class);
    }

    @Override
    protected HostingEntity toEntityImp(HostingPostDTO dto){
        return mapperUtil.use().map(dto, HostingEntity.class);
    }

}