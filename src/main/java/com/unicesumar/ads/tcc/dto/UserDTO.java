package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    @JsonProperty("id_user")
    private Integer idUser;

    @JsonProperty("Individual")
    private IndividualDTO individual;

    @JsonProperty("company_system")
    private CompanySystemDTO companySystem;

    @JsonProperty("user_type")
    private UserTypeDTO userType;

    @JsonProperty("username")
    private String username;

    @JsonIgnore
    private String password;

    @JsonProperty("admin")
    private Boolean admin;

}