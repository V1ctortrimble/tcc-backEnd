package com.unicesumar.ads.tcc.dto.personGetDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.companyDTO.CompanyGetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonCompanyGetDTO {

    @JsonProperty("id_person")
    private int idPerson;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("company")
    private CompanyGetDTO company;

    @JsonProperty("contacts")
    private List<ContactGetDTO> contacts;

    @JsonProperty("adresses")
    private List<AdressGetDTO> adresses;

    @JsonProperty("banks_details")
    private List<BankDetailsGetDTO> banksDetails;
}
