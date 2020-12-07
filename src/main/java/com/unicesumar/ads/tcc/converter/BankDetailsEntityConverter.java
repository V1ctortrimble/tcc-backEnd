package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.BankDetailsEntity;
import com.unicesumar.ads.tcc.dto.BankDetailsDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankDetailsEntityConverter extends DTOEntityConverter<BankDetailsDTO, BankDetailsEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected BankDetailsDTO toDTOImp(BankDetailsEntity entity){
        return mapperUtil.use().map(entity, BankDetailsDTO.class);
    }

    @Override
    protected BankDetailsEntity toEntityImp(BankDetailsDTO dto){
        return mapperUtil.use().map(dto, BankDetailsEntity.class);
    }

}