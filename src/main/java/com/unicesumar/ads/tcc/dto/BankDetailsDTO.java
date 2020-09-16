package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankDetailsDTO {

    @JsonProperty("id_bank_details")
    private Integer idBankDetails;

    @JsonProperty("person")
    private PersonDTO person;

    @JsonProperty("bank")
    private String bank;

    @JsonProperty("agency")
    private String agency;

    @JsonProperty("account")
    private String account;

    @JsonProperty("digit")
    private String digit;

    @JsonProperty("operation")
    private String operation;

    @JsonProperty("active")
    private Boolean active;

}