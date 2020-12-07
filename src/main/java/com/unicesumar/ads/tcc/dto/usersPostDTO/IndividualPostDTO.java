package com.unicesumar.ads.tcc.dto.usersPostDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndividualPostDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean active;

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


//    @JsonProperty("company_partners")
//    private CompanyPartnerDTO companyPartners;
//
//    @JsonProperty("passenger_travel_contracts")
//    private PassengerTravelContractDTO passengerTravelContracts;

}