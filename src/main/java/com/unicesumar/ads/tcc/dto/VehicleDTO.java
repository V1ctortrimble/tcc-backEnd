package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDTO {

    @JsonProperty("id_vehicle")
    private Integer idVehicle;

    @JsonProperty("company")
    private CompanyDTO company;

    @JsonProperty("vehicle_type")
    private VehicleTypeDTO vehicleType;

    @JsonProperty("rntrc")
    private String rntrc;

    @JsonProperty("travel_packges")
    private List<TravelPackageDTO> travelPackages;

}