package com.unicesumar.ads.tcc.dto.vehicleGetDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyGetDTO {

    @JsonProperty("id_company")
    private Integer idCompany;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty(value = "active")
    private Boolean active;

    @JsonProperty("social_reason")
    private String socialReason;

    @JsonProperty("fantasy_name")
    private String fantasyName;

    @JsonProperty("state_regis")
    private String stateRegis;

    @JsonProperty("open_date")
    private LocalDate openDate;

}