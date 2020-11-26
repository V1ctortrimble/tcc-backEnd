package com.unicesumar.ads.tcc.dto.vehiclePostDTO;

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
public class VehiclePostDTO {

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("id_vehicle_type")
    private Integer idVehicleType;

    @JsonProperty("rntrc")
    private String rntrc;

}