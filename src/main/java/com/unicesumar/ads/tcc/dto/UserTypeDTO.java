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
public class UserTypeDTO {

    @JsonProperty("id_user_type")
    private Integer idUserType;

    @JsonProperty("user_type")
    private String userType;

    @JsonProperty("users")
    private List<UserDTO> users;

}