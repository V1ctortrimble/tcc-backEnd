package com.unicesumar.ads.tcc.dto.hostingGetDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.hostingPostDTO.PersonPostDTO;
import com.unicesumar.ads.tcc.dto.hostingPutDTO.AdressPutDTO;
import com.unicesumar.ads.tcc.dto.vehicleGetDTO.CompanyGetDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HostingGetDTO {

    @JsonProperty("id_hosting")
    private Integer idHosting;

    @JsonIgnore
    private PersonPostDTO person;

    @JsonProperty("company")
    private CompanyGetDTO company;

    @JsonProperty("adress")
    private AdressPutDTO adress;

    @JsonProperty("hosting_type")
    private HostingTypeGetDTO hostingType;

    @JsonProperty("tourism_regis")
    private String tourismRegis;

    @JsonProperty("quantity_person")
    private Integer quantityPerson;

    @JsonProperty("features_hosting")
    private String featuresHosting;

    private Boolean active;

}