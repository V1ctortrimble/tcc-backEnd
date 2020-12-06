package com.unicesumar.ads.tcc.dto.travelContractPostDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.CompanyDTO;
import com.unicesumar.ads.tcc.dto.FinancialDTO;
import com.unicesumar.ads.tcc.dto.PassengerTravelContractDTO;
import com.unicesumar.ads.tcc.dto.TravelPackageDTO;
import com.unicesumar.ads.tcc.dto.vehiclePutDTO.CompanyPutDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelContractPostDTO {

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

    @JsonProperty("active")
    private Boolean active;

    @JsonIgnore
    private TravelPackageDTO travelPackage;

    @JsonProperty("id_company")
    private Integer idCompany;

    @JsonIgnore
    private CompanyPutDTO company;

    @JsonProperty("passenger")
    private PassengerTravelContractPostDTO passengerTravelContract;

    @JsonProperty("passengers")
    private List<PassengerTravelContractPostDTO> passengerTravelContracts;

}