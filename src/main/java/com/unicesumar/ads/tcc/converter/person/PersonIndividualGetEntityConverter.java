package com.unicesumar.ads.tcc.converter.person;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.dto.personGetDTO.PersonIndividualGetDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class PersonIndividualGetEntityConverter extends DTOEntityConverter<PersonIndividualGetDTO, PersonEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PersonIndividualGetDTO toDTOImp(PersonEntity entity){
        return mapperUtil.use().map(entity, PersonIndividualGetDTO.class);
    }

    @Override
    protected PersonEntity toEntityImp(PersonIndividualGetDTO dto){
        return mapperUtil.use().map(dto, PersonEntity.class);
    }

}