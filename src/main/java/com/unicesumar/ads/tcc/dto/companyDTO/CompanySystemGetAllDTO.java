package com.unicesumar.ads.tcc.dto.companyDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanySystemGetAllDTO {

    @JsonProperty("id_company_system")
    private Integer idCompanySystem;

    @JsonProperty("social_reason")
    private String socialReason;

    @JsonProperty("fantasy_name")
    private String fantasyName;

    @JsonProperty("cnpj")
    private String cnpj;


}
