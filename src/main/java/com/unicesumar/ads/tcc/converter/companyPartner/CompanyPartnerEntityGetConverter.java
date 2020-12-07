package com.unicesumar.ads.tcc.converter.companyPartner;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.CompanyPartnerEntity;
import com.unicesumar.ads.tcc.data.entity.IndividualEntity;
import com.unicesumar.ads.tcc.dto.companyDTO.CompanyPartnerGetDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyPartnerEntityGetConverter extends DTOEntityConverter<CompanyPartnerGetDTO, IndividualEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected CompanyPartnerGetDTO toDTOImp(IndividualEntity entity){
        return mapperUtil.use().map(entity, CompanyPartnerGetDTO.class);
    }

    @Override
    protected IndividualEntity toEntityImp(CompanyPartnerGetDTO dto){
        return mapperUtil.use().map(dto, IndividualEntity.class);
    }

}