package com.unicesumar.ads.tcc.dto.listPassengerPdfDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.PassengerTravelContractDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelContractPdfListDTO {
    
    @JsonProperty("id_travel_contract")
    private Integer idTravelContract;

    @JsonProperty("boarding_location")
    private String boardingLocation;

    @JsonProperty("boarding_time")
    private LocalTime boardingTime;

    @JsonProperty("issue_date")
    private LocalDateTime issueDate;

    @JsonProperty("total_contract_amount")
    private BigDecimal totalContractAmount;

    @JsonProperty("passenger_travel_contracts")
    private List<PassengerTravelContractDTO> passengerTravelContracts;

}
