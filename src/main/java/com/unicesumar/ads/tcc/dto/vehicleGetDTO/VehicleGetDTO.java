package com.unicesumar.ads.tcc.dto.vehicleGetDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.CompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleGetDTO {

    @JsonProperty("id_vehicle")
    private Integer idVehicle;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("company")
    private CompanyGetDTO company;

    @JsonProperty("vehicle_type")
    private VehicleTypeGetDTO vehicleType;

    @JsonProperty("rntrc")
    private String rntrc;

}