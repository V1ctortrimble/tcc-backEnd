package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.dto.UsersDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsersEntityConverter extends DTOEntityConverter<UsersDTO, UsersEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected UsersDTO toDTOImp(UsersEntity entity){
        return mapperUtil.use().map(entity, UsersDTO.class);
    }

    @Override
    protected UsersEntity toEntityImp(UsersDTO dto){
        return mapperUtil.use().map(dto, UsersEntity.class);
    }

}