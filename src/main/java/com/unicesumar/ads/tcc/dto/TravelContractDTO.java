package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelContractDTO {

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

    @JsonProperty("travel_Packges")
    private List<TravelPackgeDTO> travelPackgeEntities;

    @JsonProperty("companies")
    private List<CompanyDTO> companyEntities;

}