package com.unicesumar.ads.tcc.util;

import com.unicesumar.ads.tcc.dto.CompanyDTO;
import com.unicesumar.ads.tcc.dto.IndividualDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * component to paginator of List All
 */
@Component
public class PaginatorUtil {

    //TODO: Deixar metodos como um metodo geral para qualquer classe
    public Page<CompanyDTO> paginateCompanyDTO(Pageable pageable, List<CompanyDTO> dtos) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), dtos.size());
        return new PageImpl<>(dtos.subList(start, end), pageable, dtos.size());
    }

    //TODO: Deixar metodos como um metodo geral para qualquer classe
    public Page<IndividualDTO> paginateIndividualDTO(Pageable pageable, List<IndividualDTO> dtos) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), dtos.size());
        return new PageImpl<>(dtos.subList(start, end), pageable, dtos.size());
    }

}
