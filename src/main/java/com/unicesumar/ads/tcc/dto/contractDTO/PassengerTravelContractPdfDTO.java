package com.unicesumar.ads.tcc.dto.contractDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.travelContractPostDTO.IndividualPostTravelContractDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerTravelContractPdfDTO {

    @JsonProperty("id_passenger_travel_contract")
    private Integer idPassengerTravelContract;

    @JsonProperty("contracted_passenger")
    private Boolean contractedPassenger;

    @JsonProperty("paying_passenger")
    private Boolean payingPassenger;

    @JsonProperty("individual")
    private IndividualPostTravelContractDTO individual;

    @JsonProperty("individual")
    private IndividualPostTravelContractDTO individualPay;

}
