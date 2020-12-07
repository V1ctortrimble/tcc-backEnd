package com.unicesumar.ads.tcc.dto.usersPostDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.ContactDTO;
import com.unicesumar.ads.tcc.dto.IndividualDTO;
import com.unicesumar.ads.tcc.dto.companyDTO.CompanySystemDTO;
import com.unicesumar.ads.tcc.dto.personGetDTO.ContactGetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersPostDTO {

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

    @JsonProperty("active")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean active;

    @JsonProperty("individual")
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private IndividualPostDTO individual;

    @JsonProperty("company_system")
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private CompanySystemDTO companySystem;

    @JsonProperty("contact")
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private ContactDTO contactDTO;
}