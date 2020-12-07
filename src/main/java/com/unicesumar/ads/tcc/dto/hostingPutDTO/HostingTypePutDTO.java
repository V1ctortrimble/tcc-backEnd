package com.unicesumar.ads.tcc.dto.hostingPutDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HostingTypePutDTO {

    @JsonProperty("id_hosting_type")
    private Integer idHostingType;

    @JsonProperty("name_hosting_type")
    private String nameHostingType;

}