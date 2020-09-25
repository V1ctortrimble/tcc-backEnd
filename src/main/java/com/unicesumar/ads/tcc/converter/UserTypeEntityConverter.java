package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.UserTypeEntity;
import com.unicesumar.ads.tcc.dto.UserTypeDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserTypeEntityConverter extends DTOEntityConverter<UserTypeDTO, UserTypeEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected UserTypeDTO toDTOImp(UserTypeEntity entity){
        return mapperUtil.use().map(entity, UserTypeDTO.class);
    }

    @Override
    protected UserTypeEntity toEntityImp(UserTypeDTO dto){
        return mapperUtil.use().map(dto, UserTypeEntity.class);
    }

}