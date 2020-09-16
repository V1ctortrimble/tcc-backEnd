package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.entity.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonEntityConverter extends DTOEntityConverter<com.unicesumar.ads.tcc.dto.PersonDTO, PersonDTO> {

    private final MapperUtil mapperUtil;

    @Override
    protected com.unicesumar.ads.tcc.dto.PersonDTO toDTOImp(PersonDTO entity){
        return mapperUtil.use().map(entity, com.unicesumar.ads.tcc.dto.PersonDTO.class);
    }

    @Override
    protected PersonDTO toEntityImp(com.unicesumar.ads.tcc.dto.PersonDTO dto){
        return mapperUtil.use().map(dto, PersonDTO.class);
    }

}