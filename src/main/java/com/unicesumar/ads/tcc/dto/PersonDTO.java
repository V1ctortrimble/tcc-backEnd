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
public class PersonDTO {

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("contacts")
    private List<ContactDTO> contacts;

    @JsonProperty("Adresses")
    private List<AdressDTO> adresses;

    @JsonProperty("banks_details")
    private List<BankDetailsDTO> banksDetails;

}