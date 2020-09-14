package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.UserDTO;
import com.unicesumar.ads.tcc.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEntityConverter extends DTOEntityConverter<UserDTO, UserEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected UserDTO toDTOImp(UserEntity entity){
        return mapperUtil.use().map(entity, UserDTO.class);
    }

    @Override
    protected UserEntity toEntityImp(UserDTO dto){
        return mapperUtil.use().map(dto, UserEntity.class);
    }

}