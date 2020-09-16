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
public class HostingTypeDTO {

    @JsonProperty("id_hosting_type")
    private Integer idHostingType;

    @JsonProperty("name_hosting_type")
    private String nameHostingType;

}