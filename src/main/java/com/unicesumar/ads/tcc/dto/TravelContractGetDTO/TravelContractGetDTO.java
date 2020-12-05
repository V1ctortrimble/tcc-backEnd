package com.unicesumar.ads.tcc.dto.TravelContractGetDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.TravelPackageDTO;
import com.unicesumar.ads.tcc.dto.travelContractPostDTO.PassengerTravelContractPostDTO;
import com.unicesumar.ads.tcc.dto.vehiclePutDTO.CompanyPutDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelContractGetDTO {

    @JsonProperty("id_travel_contract")
    private Integer idTravelContract;

    @JsonProperty("boarding_location")
    private String boardingLocation;

    @JsonProperty("landingLocation")
    private String landingLocation;

    @JsonProperty("boarding_time")
    private LocalTime boardingTime;

    @JsonProperty("issue_date")
    private LocalDate issueDate;

    @JsonProperty("total_contract_amount")
    private BigDecimal totalContractAmount;

    @JsonProperty("id_travel_package")
    private Integer idTravelPackage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("travel_package")
    private TravelPackageDTO travelPackage;

    @JsonIgnore
    private Integer idCompany;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("company")
    private CompanyPutDTO company;

    @JsonProperty("passengers")
    private List<PassengerTravelContractGetDTO> passengerTravelContracts;

}