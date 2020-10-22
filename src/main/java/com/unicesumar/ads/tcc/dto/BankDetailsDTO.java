package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.personDTO.PersonCompanyDTO;
import com.unicesumar.ads.tcc.dto.personDTO.PersonIndividualDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankDetailsDTO {

    private String bank;

    private String agency;

    private String account;

    private String digit;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String operation;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean active;

}