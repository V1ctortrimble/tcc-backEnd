package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.mapper.DTOEntityConverter;
import com.unicesumar.ads.tcc.converter.mapper.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.PessoaFisicaDTO;
import com.unicesumar.ads.tcc.entity.PessoaFisicaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaFisicaEntityConverter extends DTOEntityConverter<PessoaFisicaDTO, PessoaFisicaEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PessoaFisicaDTO toDTOImp(PessoaFisicaEntity entity){
        return mapperUtil.use().map(entity, PessoaFisicaDTO.class);
    }

    @Override
    protected PessoaFisicaEntity toEntityImp(PessoaFisicaDTO dto){
        return mapperUtil.use().map(dto, PessoaFisicaEntity.class);
    }

}
