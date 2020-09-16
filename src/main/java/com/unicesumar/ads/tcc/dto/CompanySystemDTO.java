package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanySystemDTO {

    @JsonProperty("id_company_system")
    private Integer idCompanySystem;

    @JsonProperty("company")
    private CompanyDTO company;

    @JsonProperty("Companies")
    private List<CompanyPartnerDTO> companyPartners;

    @JsonProperty("users")
    private List<UserDTO> users;

}