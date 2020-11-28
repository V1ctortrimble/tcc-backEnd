package com.unicesumar.ads.tcc.dto.vehiclePutDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleTypePutDTO {

    @JsonProperty("id_vehicle_type")
    private Integer idVehicleType;

    @JsonProperty("name_vehicle_type")
    private String nameVehicleType;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("model")
    private String model;

    @JsonProperty("num_seats")
    private Integer numSeats;

    @JsonProperty("seats_type")
    private String seatsType;

    @JsonProperty("bathroom")
    private Boolean bathroom;

    @JsonProperty("accessibility")
    private Boolean accessibility;

    @JsonProperty("description")
    private String description;
}