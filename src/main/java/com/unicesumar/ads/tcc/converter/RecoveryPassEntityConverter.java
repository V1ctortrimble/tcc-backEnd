package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.RecoveryPassEntity;
import com.unicesumar.ads.tcc.dto.RecoveryPassDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecoveryPassEntityConverter extends DTOEntityConverter<RecoveryPassDTO, RecoveryPassEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected RecoveryPassDTO toDTOImp(RecoveryPassEntity entity){
        return mapperUtil.use().map(entity, RecoveryPassDTO.class);
    }
    @Override
    protected RecoveryPassEntity toEntityImp(RecoveryPassDTO dto){
        return mapperUtil.use().map(dto, RecoveryPassEntity.class);
    }
}
