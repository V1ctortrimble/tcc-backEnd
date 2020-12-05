package com.unicesumar.ads.tcc.dto.travelContractPostDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndividualPostTravelContractDTO {

    @JsonProperty("id_individual")
    private int idIndividual;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("rg")
    private String rg;

    @JsonProperty("name_individual")
    private String nameIndividual;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("birth_date")
    private LocalDate birthDate;


}