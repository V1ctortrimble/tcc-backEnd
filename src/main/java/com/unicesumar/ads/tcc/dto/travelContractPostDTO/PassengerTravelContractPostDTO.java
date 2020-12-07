package com.unicesumar.ads.tcc.dto.travelContractPostDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.IndividualListPdfDTO;
import com.unicesumar.ads.tcc.dto.TravelContractDTO;
import com.unicesumar.ads.tcc.dto.usersPostDTO.IndividualPostDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerTravelContractPostDTO {

    @JsonProperty("id_passenger_travel_contract")
    private Integer idPassengerTravelContract;

    @JsonProperty("contracted_passenger")
    private Boolean contractedPassenger;

    @JsonProperty("paying_passenger")
    private Boolean payingPassenger;

    @JsonProperty("id_individual")
    private Integer idIndividual;

    @JsonIgnore
    private IndividualPostTravelContractDTO individual;

    @JsonIgnore
    private TravelContractDTO contract;

}