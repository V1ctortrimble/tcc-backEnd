package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.dto.UsersDTO;
import com.unicesumar.ads.tcc.dto.usersPostDTO.UsersPostDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsersEntityPostConverter extends DTOEntityConverter<UsersPostDTO, UsersEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected UsersPostDTO toDTOImp(UsersEntity entity){
        return mapperUtil.use().map(entity, UsersPostDTO.class);
    }

    @Override
    protected UsersEntity toEntityImp(UsersPostDTO dto){
        return mapperUtil.use().map(dto, UsersEntity.class);
    }

}