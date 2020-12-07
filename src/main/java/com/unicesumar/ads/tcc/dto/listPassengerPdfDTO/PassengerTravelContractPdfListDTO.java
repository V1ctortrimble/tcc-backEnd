package com.unicesumar.ads.tcc.dto.listPassengerPdfDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.personGetDTO.IndividualGetDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerTravelContractPdfListDTO {

    @JsonProperty("id_passenger_travel_contract")
    private Integer idPassengerTravelContract;

    @JsonProperty("individual")
    private IndividualGetDTO individual;

}
