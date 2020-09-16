package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.entity.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDTO {

    @JsonProperty("id_contact")
    private Integer idContact;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("cell_phone")
    private String cellPhone;

    @JsonProperty("email")
    private String email;

}