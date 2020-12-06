package com.unicesumar.ads.tcc.dto.contractDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.TravelContractGetDTO.PassengerTravelContractGetDTO;
import com.unicesumar.ads.tcc.dto.TravelPackageDTO;
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
public class TravelContractPdfDTO {

    private String cpfPay;
    private String rgPay;
    private String nameIndividualPay;
    private String lastNamePay;

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

    @JsonProperty("route")
    private String route;

    @JsonProperty("start_date")
    private LocalDate startDate;

    @JsonProperty("end_date")
    private LocalDate endDate;

    @JsonProperty("expected_start_time" )
    private LocalTime expectedStartTime;

    @JsonProperty("estimated_end_time" )
    private LocalTime estimatedEndTime;

    @JsonIgnore
    private Integer idCompany;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("company")
    private CompanyPutDTO company;

    @JsonProperty("passengers")
    private List<PassengerTravelContractPdfDTO> passengerTravelContracts;
}
