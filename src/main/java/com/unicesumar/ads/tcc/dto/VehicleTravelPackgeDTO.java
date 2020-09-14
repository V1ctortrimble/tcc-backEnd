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
public class VehicleTravelPackgeDTO {

    @JsonProperty("id_vehicle_travel_packge")
    private Integer idVehicleTravelPackge;

    @JsonProperty("vehicles")
    private List<VehicleDTO> vehicleEntities;

}