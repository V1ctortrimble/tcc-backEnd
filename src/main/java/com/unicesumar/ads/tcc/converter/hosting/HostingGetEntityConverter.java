package com.unicesumar.ads.tcc.converter.hosting;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.HostingEntity;
import com.unicesumar.ads.tcc.dto.hostingGetDTO.HostingGetDTO;
import com.unicesumar.ads.tcc.dto.hostingPutDTO.HostingPutDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HostingGetEntityConverter extends DTOEntityConverter<HostingGetDTO, HostingEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected HostingGetDTO toDTOImp(HostingEntity entity){
        return mapperUtil.use().map(entity, HostingGetDTO.class);
    }

    @Override
    protected HostingEntity toEntityImp(HostingGetDTO dto){
        return mapperUtil.use().map(dto, HostingEntity.class);
    }

}