package com.unicesumar.ads.tcc.converter;


import com.unicesumar.ads.tcc.converter.mapper.DTOEntityConverter;
import com.unicesumar.ads.tcc.dto.PessoaDTO;
import com.unicesumar.ads.tcc.entity.PessoaEntity;
import com.unicesumar.ads.tcc.converter.mapper.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaEntityConverter extends DTOEntityConverter<PessoaDTO, PessoaEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PessoaDTO toDTOImp(PessoaEntity entity){
        return mapperUtil.use().map(entity, PessoaDTO.class);
    }

    @Override
    protected PessoaEntity toEntityImp(PessoaDTO dto){
        return mapperUtil.use().map(dto, PessoaEntity.class);
    }

}
