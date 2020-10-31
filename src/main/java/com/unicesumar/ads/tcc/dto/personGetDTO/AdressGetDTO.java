package com.unicesumar.ads.tcc.dto.personGetDTO;

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
public class AdressGetDTO {

    @JsonProperty("id_adress")
    private int idAdress;

    private String adress;

    @JsonProperty("adress_number")
    private Integer adressNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String additional;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String neighborhood;

    private String city;

    private String state;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("zip_code")
    private String zipCode;

}