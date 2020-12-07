package com.unicesumar.ads.tcc.converter.person;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.dto.personDTO.PersonCompanyDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonCompanyEntityConverter extends DTOEntityConverter<PersonCompanyDTO, PersonEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PersonCompanyDTO toDTOImp(PersonEntity entity){
        return mapperUtil.use().map(entity, PersonCompanyDTO.class);
    }

    @Override
    protected PersonEntity toEntityImp(PersonCompanyDTO dto){
        return mapperUtil.use().map(dto, PersonEntity.class);
    }
}
