package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.converter.mapper.DTOEntityConverter;
import com.unicesumar.ads.tcc.converter.mapper.util.MapperUtil;
import com.unicesumar.ads.tcc.dto.PessoaJuridicaDTO;
import com.unicesumar.ads.tcc.entity.PessoaJuridicaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaJuridicaEntityConverter extends DTOEntityConverter<PessoaJuridicaDTO, PessoaJuridicaEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PessoaJuridicaDTO toDTOImp(PessoaJuridicaEntity entity){
        return mapperUtil.use().map(entity, PessoaJuridicaDTO.class);
    }

    @Override
    protected PessoaJuridicaEntity toEntityImp(PessoaJuridicaDTO dto){
        return mapperUtil.use().map(dto, PessoaJuridicaEntity.class);
    }

}
