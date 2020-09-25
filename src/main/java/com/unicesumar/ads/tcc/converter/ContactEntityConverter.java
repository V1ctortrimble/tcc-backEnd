package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.ContactEntity;
import com.unicesumar.ads.tcc.dto.ContactDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactEntityConverter extends DTOEntityConverter<ContactDTO, ContactEntity>{

    private final MapperUtil mapperUtil;

    @Override
    protected ContactDTO toDTOImp(ContactEntity entity){
        return mapperUtil.use().map(entity, ContactDTO.class);
    }

    @Override
    protected ContactEntity toEntityImp(ContactDTO dto){
        return mapperUtil.use().map(dto, ContactEntity.class);
    }

}