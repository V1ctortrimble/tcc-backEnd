package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.ContactEntity;
import com.unicesumar.ads.tcc.dto.ContactDTO;
import com.unicesumar.ads.tcc.dto.personGetDTO.ContactGetDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactEntityConverter extends DTOEntityConverter<ContactGetDTO, ContactEntity>{

    private final MapperUtil mapperUtil;

    @Override
    protected ContactGetDTO toDTOImp(ContactEntity entity){
        return mapperUtil.use().map(entity, ContactGetDTO.class);
    }

    @Override
    protected ContactEntity toEntityImp(ContactGetDTO dto){
        return mapperUtil.use().map(dto, ContactEntity.class);
    }

}