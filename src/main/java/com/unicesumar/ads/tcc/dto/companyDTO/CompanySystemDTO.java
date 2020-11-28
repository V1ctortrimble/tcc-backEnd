package com.unicesumar.ads.tcc.dto.companyDTO;

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
public class CompanySystemDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id_company_system")
    private Integer idCompanySystem;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("active")
    private Boolean active;
}