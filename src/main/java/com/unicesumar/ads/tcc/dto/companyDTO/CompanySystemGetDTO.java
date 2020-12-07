package com.unicesumar.ads.tcc.dto.companyDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanySystemGetDTO {

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("company")
    private CompanyGetDTO company;
}
