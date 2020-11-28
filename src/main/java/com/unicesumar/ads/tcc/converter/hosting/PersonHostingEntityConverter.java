package com.unicesumar.ads.tcc.converter.hosting;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.dto.hostingPostDTO.PersonPostDTO;
import com.unicesumar.ads.tcc.dto.personGetDTO.PersonIndividualGetDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class PersonHostingEntityConverter extends DTOEntityConverter<PersonPostDTO, PersonEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PersonPostDTO toDTOImp(PersonEntity entity){
        return mapperUtil.use().map(entity, PersonPostDTO.class);
    }

    @Override
    protected PersonEntity toEntityImp(PersonPostDTO dto){
        return mapperUtil.use().map(dto, PersonEntity.class);
    }

}