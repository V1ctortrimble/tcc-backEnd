package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.CompanyEntity;
import com.unicesumar.ads.tcc.dto.CompanyDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyEntityConverter extends DTOEntityConverter<CompanyDTO, CompanyEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected CompanyDTO toDTOImp(CompanyEntity entity){
        return mapperUtil.use().map(entity, CompanyDTO.class);
    }

    @Override
    protected CompanyEntity toEntityImp(CompanyDTO dto){
        return mapperUtil.use().map(dto, CompanyEntity.class);
    }

}