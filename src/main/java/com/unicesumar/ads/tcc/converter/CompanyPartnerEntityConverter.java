package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.CompanyPartnerDTO;
import com.unicesumar.ads.tcc.entity.CompanyPartnerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyPartnerEntityConverter extends DTOEntityConverter<CompanyPartnerDTO, CompanyPartnerEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected CompanyPartnerDTO toDTOImp(CompanyPartnerEntity entity){
        return mapperUtil.use().map(entity, CompanyPartnerDTO.class);
    }

    @Override
    protected CompanyPartnerEntity toEntityImp(CompanyPartnerDTO dto){
        return mapperUtil.use().map(dto, CompanyPartnerEntity.class);
    }

}