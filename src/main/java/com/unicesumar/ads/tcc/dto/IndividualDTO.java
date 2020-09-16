package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.entity.PassengerTravelContractDTO;
import com.unicesumar.ads.tcc.entity.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndividualDTO {

    @JsonProperty("id_individual")
    private Integer idIndividual;

    @JsonProperty("person")
    private PersonDTO person;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("rg")
    private String rg;

    @JsonProperty("name_individual")
    private String nameIndividual;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("company_partners")
    private List<CompanyPartnerDTO> companyPartners;

    @JsonProperty("passenger_travel_contracts" )
    private List<PassengerTravelContractDTO> passengerTravelContracts;


}