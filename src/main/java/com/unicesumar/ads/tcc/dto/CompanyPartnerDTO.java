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
public class CompanyPartnerDTO {

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("active")
    public Boolean active;

}