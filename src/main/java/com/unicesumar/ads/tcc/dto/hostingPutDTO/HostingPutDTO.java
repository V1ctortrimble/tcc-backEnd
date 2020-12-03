package com.unicesumar.ads.tcc.dto.hostingPutDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.AdressDTO;
import com.unicesumar.ads.tcc.dto.hostingPostDTO.PersonPostDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HostingPutDTO {

    @JsonProperty("id_hosting")
    private Integer idHosting;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("document")
    private String cnpj;

    @JsonIgnore
    private PersonPostDTO person;

    @JsonProperty("adress")
    private AdressDTO adress;

    @JsonProperty("hosting_type")
    private HostingTypePutDTO hostingType;

    @JsonProperty("tourism_regis")
    private String tourismRegis;

    @JsonProperty("quantity_person")
    private Integer quantityPerson;

    @JsonProperty("features_hosting")
    private String featuresHosting;

    private Boolean active;

}