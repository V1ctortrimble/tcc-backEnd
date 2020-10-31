package com.unicesumar.ads.tcc.dto.personGetDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.AdressDTO;
import com.unicesumar.ads.tcc.dto.BankDetailsDTO;
import com.unicesumar.ads.tcc.dto.ContactDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonGetDTO {

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
