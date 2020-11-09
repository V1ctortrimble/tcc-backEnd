package com.unicesumar.ads.tcc.dto.companyDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyGetDTO {

    @JsonProperty("social_reason")
    private String socialReason;

    @JsonProperty("fantasy_name")
    private String fantasyName;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("state_regis")
    private String stateRegis;

    @JsonProperty("open_date")
    private LocalDate openDate;

    @JsonProperty(value = "active")
    private Boolean active;
}
