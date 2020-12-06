package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.TravelContractEntity;
import com.unicesumar.ads.tcc.dto.contractDTO.TravelContractPdfDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TravelContractPdfDTOConverter extends DTOEntityConverter<TravelContractPdfDTO, TravelContractEntity> {
    private final MapperUtil mapperUtil;

    @Override
    protected TravelContractPdfDTO toDTOImp(TravelContractEntity entity){
        return mapperUtil.use().map(entity, TravelContractPdfDTO.class);
    }
    @Override
    protected TravelContractEntity toEntityImp(TravelContractPdfDTO dto){
        return mapperUtil.use().map(dto, TravelContractEntity.class);
    }
}
