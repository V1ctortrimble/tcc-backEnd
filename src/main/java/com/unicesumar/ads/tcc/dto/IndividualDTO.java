package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.data.entity.PassengerTravelContractEntity;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
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
public class IndividualDTO implements Comparable<IndividualDTO>{

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

    @Override
    public int compareTo(IndividualDTO o) {
        return getNameIndividual().compareToIgnoreCase(o.getNameIndividual());
    }

//    @JsonProperty("company_partners")
//    private CompanyPartnerDTO companyPartners;
//
//    @JsonProperty("passenger_travel_contracts")
//    private PassengerTravelContractDTO passengerTravelContracts;

}