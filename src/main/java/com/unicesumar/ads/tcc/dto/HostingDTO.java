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
public class HostingDTO {

    @JsonProperty("id_hosting")
    private Integer idHosting;

    @JsonProperty("person")
    private PersonDTO person;

    @JsonProperty("hosting_type")
    private HostingTypeDTO hostingType;

    @JsonProperty("adress")
    private AdressDTO adress;

    @JsonProperty("tourism_regis")
    private String tourismRegis;

    @JsonProperty("quantityPerson")
    private Integer quantityPerson;

    @JsonProperty("featuresHosting")
    private Integer featuresHosting;

    @JsonProperty("travel_packges")
    private List<TravelPackageDTO> travelPackages;

}