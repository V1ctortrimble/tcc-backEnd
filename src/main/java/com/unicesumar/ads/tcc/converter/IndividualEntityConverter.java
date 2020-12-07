package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.IndividualEntity;
import com.unicesumar.ads.tcc.dto.IndividualDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IndividualEntityConverter extends DTOEntityConverter<IndividualDTO, IndividualEntity>{

    private final MapperUtil mapperUtil;

    @Override
    protected IndividualDTO toDTOImp(IndividualEntity entity){
        return mapperUtil.use().map(entity, IndividualDTO.class);
    }
    @Override
    protected IndividualEntity toEntityImp(IndividualDTO dto){
        return mapperUtil.use().map(dto, IndividualEntity.class);
    }

}