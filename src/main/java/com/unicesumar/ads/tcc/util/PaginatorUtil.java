package com.unicesumar.ads.tcc.util;

import com.unicesumar.ads.tcc.dto.CompanyDTO;
import com.unicesumar.ads.tcc.dto.IndividualDTO;
import com.unicesumar.ads.tcc.dto.companyDTO.CompanyPartnerGetDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static com.unicesumar.ads.tcc.util.constants.UtilsConstants.PAGINA_NAO_ENCONTRADA;

/**
 * component to paginator of List All
 */
@Component
public class PaginatorUtil {

    public Page<CompanyDTO> paginateCompanyDTO(Pageable pageable, List<CompanyDTO> dtos) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), dtos.size());
        validateFinalPage(start, dtos.size());
        return new PageImpl<>(dtos.subList(start, end), pageable, dtos.size());
    }

    public Page<IndividualDTO> paginateIndividualDTO(Pageable pageable, List<IndividualDTO> dtos) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), dtos.size());
        validateFinalPage(start, dtos.size());
        return new PageImpl<>(dtos.subList(start, end), pageable, dtos.size());
    }

    public Page<CompanyPartnerGetDTO> paginateCompanyPartnerDTO(Pageable pageable, List<CompanyPartnerGetDTO> dtos) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), dtos.size());
        validateFinalPage(start, dtos.size());
        return new PageImpl<>(dtos.subList(start, end), pageable, dtos.size());
    }

    /**
     * Method to validate if it is the last page
     */
    private void validateFinalPage(int start, int size) {
        if (start > size) {
            throw new HttpBadRequestException(PAGINA_NAO_ENCONTRADA);
        }
    }
}
