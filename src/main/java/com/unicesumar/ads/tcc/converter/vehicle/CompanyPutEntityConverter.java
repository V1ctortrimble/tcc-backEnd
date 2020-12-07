package com.unicesumar.ads.tcc.converter.vehicle;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.CompanyEntity;
import com.unicesumar.ads.tcc.dto.CompanyDTO;
import com.unicesumar.ads.tcc.dto.vehiclePutDTO.CompanyPutDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyPutEntityConverter extends DTOEntityConverter<CompanyPutDTO, CompanyEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected CompanyPutDTO toDTOImp(CompanyEntity entity){
        return mapperUtil.use().map(entity, CompanyPutDTO.class);
    }

    @Override
    protected CompanyEntity toEntityImp(CompanyPutDTO dto){
        return mapperUtil.use().map(dto, CompanyEntity.class);
    }

}