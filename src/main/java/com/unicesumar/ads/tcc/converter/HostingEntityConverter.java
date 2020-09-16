package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.entity.HostingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HostingEntityConverter extends DTOEntityConverter<com.unicesumar.ads.tcc.dto.HostingDTO, HostingDTO> {

    private final MapperUtil mapperUtil;

    @Override
    protected com.unicesumar.ads.tcc.dto.HostingDTO toDTOImp(HostingDTO entity){
        return mapperUtil.use().map(entity, com.unicesumar.ads.tcc.dto.HostingDTO.class);
    }

    @Override
    protected HostingDTO toEntityImp(com.unicesumar.ads.tcc.dto.HostingDTO dto){
        return mapperUtil.use().map(dto, HostingDTO.class);
    }

}