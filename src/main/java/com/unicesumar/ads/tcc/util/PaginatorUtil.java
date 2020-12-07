package com.unicesumar.ads.tcc.util;

import com.unicesumar.ads.tcc.data.entity.CompanyEntity;
import com.unicesumar.ads.tcc.data.entity.IndividualEntity;
import com.unicesumar.ads.tcc.data.entity.TravelPackageEntity;
import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.dto.CompanyDTO;
import com.unicesumar.ads.tcc.dto.IndividualDTO;
import com.unicesumar.ads.tcc.dto.TravelPackageDTO;
import com.unicesumar.ads.tcc.dto.UsersDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import com.unicesumar.ads.tcc.service.CompanyService;
import com.unicesumar.ads.tcc.service.IndividualService;
import com.unicesumar.ads.tcc.service.TravelPackageService;
import com.unicesumar.ads.tcc.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.*;
import static com.unicesumar.ads.tcc.util.constants.UtilsConstants.PAGINA_NAO_ENCONTRADA;

/**
 * component to paginator of List All
 */
@Component
@RequiredArgsConstructor
public class PaginatorUtil {

    private final IndividualService individualService;
    private final CompanyService companyService;
    private final UsersService usersService;
    private final TravelPackageService travelPackageService;

    /**
     * Method that converts Entity to DTO so that the pagination does not change IndividualDTO
     */
    public Page<IndividualDTO> convertDTOIndividualToPages(Optional<String> cpf, Optional<String> rg,
                                                           Optional<String> name,
                                                           Optional<String> lastName,
                                                           Boolean active,
                                                           Pageable pageable) {
        Page<IndividualEntity> individualEntities = individualService.getIndividualFilter(cpf, rg, name, lastName,
                active, pageable);
        long offSet = pageable.getOffset();
        long totElements = individualEntities.getTotalElements();
        long totPages = individualEntities.getTotalPages();
        ValidateTotalPagesIndividual(totPages);
        validateFinalPage(offSet, totElements);
        return individualEntities.map(new Function<IndividualEntity, IndividualDTO>() {
            @Override
            public IndividualDTO apply(IndividualEntity t) {
                return new ModelMapper().map(t, IndividualDTO.class);
            }
        });
    }

    /**
     * Method that converts Entity to DTO so that the pagination does not change IndividualDTO
     */
    public Page<TravelPackageDTO> convertDTOTravelPackageToPages(Integer idTravelPackge,
                                                                  Optional<String> nameTravelPackge,
                                                                  Optional<String> originName,
                                                                  Optional<String> destinationName,
                                                                  Boolean active,
                                                                  Pageable pageable) {
        Page<TravelPackageEntity> travelPackageEntities = travelPackageService.getTravelPackageFilter(idTravelPackge, nameTravelPackge,
                originName, destinationName, active, pageable);
        long offSet = pageable.getOffset();
        long totElements = travelPackageEntities.getTotalElements();
        long totPages = travelPackageEntities.getTotalPages();
        ValidateTotalPagesTravelPackage(totPages);
        validateFinalPage(offSet, totElements);
        return travelPackageEntities.map(new Function<TravelPackageEntity, TravelPackageDTO>() {
            @Override
            public TravelPackageDTO apply(TravelPackageEntity t) {
                return new ModelMapper().map(t, TravelPackageDTO.class);
            }
        });
    }




    /**
     * Method that converts Entity to DTO so that the pagination does not change CompanyDTO
     */
    public Page<CompanyDTO> convertDTOCompanyToPages(Optional<String> cnpj, Optional<String> socialReason,
                                                     Optional<String> fantasyName,
                                                     Optional<String> stateRegis,
                                                     Boolean active,
                                                     Pageable pageable) {
        Page<CompanyEntity> individualEntities = companyService.getIndividualFilter(cnpj, socialReason, fantasyName,
                stateRegis, active, pageable);
        long offSet = pageable.getOffset();
        long totElements = individualEntities.getTotalElements();
        long totPages = individualEntities.getTotalPages();
        ValidateTotalPagesCompany(totPages);
        validateFinalPage(offSet, totElements);
        return individualEntities.map(new Function<CompanyEntity, CompanyDTO>() {
            @Override
            public CompanyDTO apply(CompanyEntity t) {
                return new ModelMapper().map(t, CompanyDTO.class);
            }
        });
    }

    public Page<UsersDTO> convertDTOUserToPages(Optional<String> username, Optional<String> name, Optional<String> lastName,
                                                Optional<String> cpf, Boolean active, Pageable pageable) {
        Page<UsersEntity> usersEntities = usersService.getUsersFilter(username, name, lastName, cpf, active, pageable);
        long offSet = pageable.getOffset();
        long totElements = usersEntities.getTotalElements();
        long totPages = usersEntities.getTotalPages();
        ValidateTotalPagesUsers(totPages);
        validateFinalPage(offSet, totElements);
        return usersEntities.map(new Function<UsersEntity, UsersDTO>() {
            @Override
            public UsersDTO apply(UsersEntity t) {
                return new ModelMapper().map(t, UsersDTO.class);
            }
        });
    }



    /**
     * Method to validate Total Pages Individual
     */
    private void ValidateTotalPagesTravelPackage(long totPages) {
        if (totPages == 0) {
            throw new HttpNotFoundException("Nenhuma Viagem localizada");
        }
    }

    /**
     * Method to validate Total Pages Individual
     */
    private void ValidateTotalPagesIndividual(long totPages) {
        if (totPages == 0) {
            throw new HttpNotFoundException(NENHUMA_PESSOA_FOI_LOCALIZADA);
        }
    }

    /**
     * Method to validate Total Pages Users
     */
    private void ValidateTotalPagesUsers(long totPages) {
        if (totPages == 0) {
            throw new HttpNotFoundException(NENHUM_USUARIO_LOCALIZADO);
        }
    }

    /**
     * Method to validate Total Pages Company
     */
    private void ValidateTotalPagesCompany(long totPages) {
        if (totPages == 0) {
            throw new HttpNotFoundException(NENHUMA_EMPRESA_LOCALIZADA);
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
