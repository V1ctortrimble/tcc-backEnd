package com.unicesumar.ads.tcc.dto.TravelContractGetDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.travelContractPostDTO.IndividualPostTravelContractDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerTravelContractGetDTO {

    @JsonProperty("id_passenger_travel_contract")
    private Integer idPassengerTravelContract;

    @JsonProperty("contracted_passenger")
    private Boolean contractedPassenger;

    @JsonProperty("paying_passenger")
    private Boolean payingPassenger;

    @JsonProperty("individual")
    private IndividualPostTravelContractDTO individual;

}