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
public class HostingDTO {

    @JsonProperty("id_hosting")
    private Integer idHosting;

    @JsonProperty("tourism_regis")
    private String tourismRegis;

    @JsonProperty("address")
    private String address;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("complement")
    private String complement;

    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("quantityPerson")
    private Integer quantityPerson;

    @JsonProperty("featuresHosting")
    private Integer featuresHosting;

}