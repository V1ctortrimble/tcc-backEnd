package com.unicesumar.ads.tcc.util;

import com.unicesumar.ads.tcc.data.entity.IndividualEntity;
import com.unicesumar.ads.tcc.dto.IndividualDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import com.unicesumar.ads.tcc.service.IndividualService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.NENHUMA_PESSOA_FOI_LOCALIZADA;
import static com.unicesumar.ads.tcc.util.constants.UtilsConstants.PAGINA_NAO_ENCONTRADA;

/**
 * component to paginator of List All
 */
@Component
@RequiredArgsConstructor
public class PaginatorUtil {

    private final IndividualService individualService;

    /**
     * Method that converts Entity to DTO so that the pagination does not change
     */
    public Page<IndividualDTO> convertDTOIndividualToPages(Optional<String> cpf, Optional<String> rg, Optional<String> name,
                                                           Optional<String> lastName,
                                                           Pageable pageable) {
        Page<IndividualEntity> individualEntities = individualService.getIndividualFilter(cpf, rg, name, lastName,
                true, pageable);
        long offSet = pageable.getOffset();
        long totElements = individualEntities.getTotalElements();
        long totPages = individualEntities.getTotalPages();
        ValidateTotalPages(totPages);
        validateFinalPage(offSet, totElements);
        return individualEntities.map(new Function<IndividualEntity, IndividualDTO>() {
            @Override
            public IndividualDTO apply(IndividualEntity t) {
                return new ModelMapper().map(t, IndividualDTO.class);
            }
        });
    }

    /**
     * Method to validate Total Pages
     */
    private void ValidateTotalPages(long totPages) {
        if (totPages == 0) {
            throw new HttpNotFoundException(NENHUMA_PESSOA_FOI_LOCALIZADA);
        }
    }

    /**
     * Method to validate if it is the last page
     */
    private void validateFinalPage(long offSet, long totElements) {
        if(offSet >= totElements) {
            throw new HttpBadRequestException(PAGINA_NAO_ENCONTRADA);
        }
    }
}
