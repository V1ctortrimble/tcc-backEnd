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

    @JsonProperty("company")
    private CompanyDTO companyDTO;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("vehicle_type")
    private VehicleTypeDTO vehicleTypeDTO;

    @JsonProperty("rntrc")
    private String rntrc;

}