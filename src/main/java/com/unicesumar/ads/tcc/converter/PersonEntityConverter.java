package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.PersonDTO;
import com.unicesumar.ads.tcc.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonEntityConverter extends DTOEntityConverter<PersonDTO, PersonEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PersonDTO toDTOImp(PersonEntity entity){
        return mapperUtil.use().map(entity, PersonDTO.class);
    }

    @Override
    protected PersonEntity toEntityImp(PersonDTO dto){
        return mapperUtil.use().map(dto, PersonEntity.class);
    }

}