package com.unicesumar.ads.tcc.converter.person;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.CompanySystemEntity;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.dto.companyDTO.CompanySystemDTO;
import com.unicesumar.ads.tcc.dto.personGetDTO.PersonGetDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class PersonGetEntityConverter extends DTOEntityConverter<PersonGetDTO, PersonEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PersonGetDTO toDTOImp(PersonEntity entity){
        return mapperUtil.use().map(entity, PersonGetDTO.class);
    }

    @Override
    protected PersonEntity toEntityImp(PersonGetDTO dto){
        return mapperUtil.use().map(dto, PersonEntity.class);
    }

}