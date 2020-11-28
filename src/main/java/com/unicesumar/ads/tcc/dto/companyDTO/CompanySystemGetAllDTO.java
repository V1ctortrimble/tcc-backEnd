package com.unicesumar.ads.tcc.dto.companyDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

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

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("open_date")
    private LocalDate openDate;


}
