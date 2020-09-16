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

    @JsonProperty("adress")
    private AdressDTO adress;

    @JsonProperty("tourism_regis")
    private String tourismRegis;

    @JsonProperty("quantity_person")
    private Integer quantityPerson;

    @JsonProperty("features_hosting")
    private Integer featuresHosting;

}