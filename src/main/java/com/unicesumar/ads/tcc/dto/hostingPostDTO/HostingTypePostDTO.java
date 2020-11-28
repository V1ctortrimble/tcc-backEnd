package com.unicesumar.ads.tcc.dto.hostingPostDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HostingTypePostDTO {

    @JsonProperty("id_hosting_type")
    private Integer idHostingType;

    @JsonProperty("name_hosting_type")
    private String nameHostingType;

}