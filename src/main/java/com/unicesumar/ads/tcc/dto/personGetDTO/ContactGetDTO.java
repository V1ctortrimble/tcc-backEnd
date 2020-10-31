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
public class ContactGetDTO {

    @JsonProperty("id_contact")
    private int idContact;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("cell_phone")
    private String cellPhone;

    @JsonProperty("cell_whats")
    private Boolean cellwhats;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

}