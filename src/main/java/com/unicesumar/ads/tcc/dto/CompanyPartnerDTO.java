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

    @JsonProperty("id_company_partner")
    private Integer idCompanyPartner;

    @JsonProperty("active")
    private Boolean active;

}