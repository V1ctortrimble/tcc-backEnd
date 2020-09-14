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

    @JsonProperty("id_company")
    private Integer idCompany;

    @JsonProperty("social_reason")
    private String socialReason;

    @JsonProperty("fantasy_name")
    private String fantasyName;

    @JsonProperty("state_regis")
    private String stateRegis;

    @JsonProperty("open_date")
    private LocalDate openDate;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("vehicles")
    private List<VehicleDTO> vehicleEntities;

    @JsonProperty("person")
    private PersonDTO personEntity;

}