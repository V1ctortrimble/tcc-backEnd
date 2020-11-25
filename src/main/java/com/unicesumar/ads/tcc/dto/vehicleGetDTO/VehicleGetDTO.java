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

    @JsonProperty("company")
    private CompanyGetDTO companyDTO;

    @JsonProperty("vehicle_type")
    private VehicleTypeGetDTO vehicleTypeGetDTO;

    @JsonProperty("rntrc")
    private String rntrc;

}