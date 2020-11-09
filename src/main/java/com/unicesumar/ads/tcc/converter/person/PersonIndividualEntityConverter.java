package com.unicesumar.ads.tcc.converter.person;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.dto.personDTO.PersonIndividualDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonIndividualEntityConverter extends DTOEntityConverter<PersonIndividualDTO, PersonEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PersonIndividualDTO toDTOImp(PersonEntity entity){
        return mapperUtil.use().map(entity, PersonIndividualDTO.class);
    }

    @Override
    protected PersonEntity toEntityImp(PersonIndividualDTO dto){
        return mapperUtil.use().map(dto, PersonEntity.class);
    }

}