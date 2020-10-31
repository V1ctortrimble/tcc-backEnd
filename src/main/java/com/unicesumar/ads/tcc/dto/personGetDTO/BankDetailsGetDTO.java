package com.unicesumar.ads.tcc.dto.personGetDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankDetailsGetDTO {

    @JsonProperty("id_bank")
    private int idBankDetails;

    private String bank;

    private String agency;

    private String account;

    private String digit;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String operation;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean active;

}