package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.FinancialDTO;
import com.unicesumar.ads.tcc.entity.FinancialEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FinancialEntityConverter extends DTOEntityConverter<FinancialDTO, FinancialEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected FinancialDTO toDTOImp(FinancialEntity entity){
        return mapperUtil.use().map(entity, FinancialDTO.class);
    }

    @Override
    protected FinancialEntity toEntityImp(FinancialDTO dto){
        return mapperUtil.use().map(dto, FinancialEntity.class);
    }

}