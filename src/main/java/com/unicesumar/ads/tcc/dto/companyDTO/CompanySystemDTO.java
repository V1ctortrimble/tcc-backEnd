package com.unicesumar.ads.tcc.dto.companyDTO;

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
public class CompanySystemDTO {

    @JsonProperty("cnpj")
    private String cnpj;
}