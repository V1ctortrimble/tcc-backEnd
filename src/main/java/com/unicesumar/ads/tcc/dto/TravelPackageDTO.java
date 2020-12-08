package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.data.entity.HostingEntity;
import com.unicesumar.ads.tcc.dto.hostingPutDTO.HostingPutDTO;
import com.unicesumar.ads.tcc.dto.vehicleGetDTO.VehicleGetDTO;
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
public class TravelPackageDTO {

    @JsonProperty("id_travel_package")
    private Integer idTravelPackage;

    @JsonProperty("name_travel_package")
    private String nameTravelPackage;

    @JsonProperty("desc_travel_package")
    private String descrTravelPackage;

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

    @JsonProperty("estimated_end_time" )
    private LocalTime estimatedEndTime;

    @JsonProperty("end_date")
    private LocalDate endDate;

    @JsonProperty("feature_travel_packge")
    private String featureTravelPackge;

    @JsonProperty("registration_date")
    private LocalDate registrationDate;

    private Boolean active;

    @JsonProperty("hostings")
    private List<Integer> IdsHost;

    @JsonProperty("vehicles")
    private List<Integer> IdsVehi;

//    @JsonProperty("travel_contracts")
//    private List<TravelContractDTO> travelContracts;

    @JsonIgnore
    private List<HostingPutDTO> hostings;
    @JsonIgnore
    private List<VehicleGetDTO> vehicles;


}