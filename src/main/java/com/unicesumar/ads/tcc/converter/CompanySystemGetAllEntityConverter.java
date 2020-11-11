package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.CompanySystemEntity;
import com.unicesumar.ads.tcc.dto.companyDTO.CompanySystemGetAllDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanySystemGetAllEntityConverter extends DTOEntityConverter<CompanySystemGetAllDTO, CompanySystemEntity>{

    private final MapperUtil mapperUtil;

    @Override
    protected CompanySystemGetAllDTO toDTOImp(CompanySystemEntity entity){
        return mapperUtil.use().map(entity, CompanySystemGetAllDTO.class);
    }

    @Override
    protected CompanySystemEntity toEntityImp(CompanySystemGetAllDTO dto){
        return mapperUtil.use().map(dto, CompanySystemEntity.class);
    }
}
