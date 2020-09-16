package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonEntityConverter extends DTOEntityConverter<com.unicesumar.ads.tcc.dto.PersonDTO, PersonEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected com.unicesumar.ads.tcc.dto.PersonDTO toDTOImp(PersonEntity entity){
        return mapperUtil.use().map(entity, com.unicesumar.ads.tcc.dto.PersonDTO.class);
    }

    @Override
    protected PersonEntity toEntityImp(com.unicesumar.ads.tcc.dto.PersonDTO dto){
        return mapperUtil.use().map(dto, PersonEntity.class);
    }

}