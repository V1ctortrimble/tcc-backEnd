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
public class HostingTravelPackageDTO {

    @JsonProperty("id_hosting_travel_package")
    private Integer idHostingTravelPackage;

    @JsonProperty("hostings")
    private List<HostingDTO> hostingEntities;

}