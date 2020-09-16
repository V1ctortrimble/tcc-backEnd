package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.entity.CompanySystemEntity;
import com.unicesumar.ads.tcc.entity.UserTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @JsonProperty("password")
    private String password;

}