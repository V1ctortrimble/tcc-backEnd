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

    @JsonProperty("id_person")
    private Integer idPerson;

    @JsonProperty("contacts")
    private List<ContactDTO> contactEntities;

    @JsonProperty("Adresses")
    private List<AdressDTO> adressEntities;

    @JsonProperty("banks_details")
    private List<BankDetailsDTO> bankDetailsEntities;

    @JsonProperty("hostings")
    private List<HostingDTO> hostingEntities;

}