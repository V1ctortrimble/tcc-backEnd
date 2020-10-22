package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDTO {

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