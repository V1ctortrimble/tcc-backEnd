package com.unicesumar.ads.tcc.dto.personGetDTO;

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
public class PersonIndividualGetDTO {

    @JsonProperty("id_person")
    private int idPerson;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("individual")
    private IndividualGetDTO individual;

    @JsonProperty("contacts")
    private List<ContactGetDTO> contacts;

    @JsonProperty("adresses")
    private List<AdressGetDTO> adresses;

    @JsonProperty("banks_details")
    private List<BankDetailsGetDTO> banksDetails;
}
