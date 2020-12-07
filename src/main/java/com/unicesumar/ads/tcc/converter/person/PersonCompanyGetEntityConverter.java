package com.unicesumar.ads.tcc.converter.person;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.dto.personGetDTO.PersonCompanyGetDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonCompanyGetEntityConverter extends DTOEntityConverter<PersonCompanyGetDTO, PersonEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PersonCompanyGetDTO toDTOImp(PersonEntity entity){
        return mapperUtil.use().map(entity, PersonCompanyGetDTO.class);
    }

    @Override
    protected PersonEntity toEntityImp(PersonCompanyGetDTO dto){
        return mapperUtil.use().map(dto, PersonEntity.class);
    }
}
