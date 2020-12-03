package com.unicesumar.ads.tcc.dto.travelPackagePostDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.VehicleDTO;
import com.unicesumar.ads.tcc.dto.hostingPutDTO.HostingPutDTO;
import com.unicesumar.ads.tcc.dto.vehicleGetDTO.VehicleGetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelPackageGetDTO {

    @JsonProperty("id_travel_package")
    private Integer idTravelPackage;

    @JsonProperty("name_travel_package")
    private String nameTravelPackage;

    @JsonProperty("desc_travel_package")
    private String descTravelPackage;

    @JsonProperty("destination_name")
    private String destinationName;

    @JsonProperty("origin_name")
    private String originName;

    @JsonProperty("adult_price")
    private BigDecimal adultPrice;

    @JsonProperty("child_price")
    private BigDecimal childPrice;

    @JsonProperty("route")
    private String route;

    @JsonProperty("payment_methods")
    private String paymentMethods;

    @JsonProperty("start_date")
    private LocalDate startDate;

    @JsonProperty("expected_start_time" )
    private LocalTime expectedStartTime;

    @JsonProperty("end_date")
    private LocalDate endDate;

    @JsonProperty("estimated_end_time" )
    private LocalTime estimatedEndTime;

    @JsonProperty("feature_travel_packge")
    private String featureTravelPackge;

    @JsonProperty("registration_date")
    private LocalDate registrationDate;

    private Boolean active;

//    @JsonProperty("travel_contracts")
//    private List<TravelContractDTO> travelContractDTOS;

    @JsonProperty("hostings")
    private List<HostingPutDTO> hostings;

    @JsonProperty("vehicles")
    private List<VehicleGetDTO> vehicles;

}