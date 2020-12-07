package com.unicesumar.ads.tcc.dto.listPassengerPdfDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelPackagePdfListDTO {

    @JsonProperty("name_travel_package")
    private String nameTravelPackage;

    @JsonProperty("travel_contracts")
    private List<TravelContractPdfListDTO> travelContracts;

}
