package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.companyDTO.CompanySystemDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDTO {

    @JsonProperty("username")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String username;

    @JsonProperty("password")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @JsonProperty("repeat_password")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String repeatPassword;

    @JsonProperty("admin")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean admin;

    @JsonProperty("individual")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private IndividualDTO individual;

    @JsonProperty("company_system")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CompanySystemDTO companySystemDTO;

}