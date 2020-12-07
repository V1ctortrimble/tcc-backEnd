package com.unicesumar.ads.tcc.dto.contractPdfDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.personGetDTO.PersonIndividualGetDTO;

import java.time.LocalDate;
import java.util.List;

public class IndividualContractPdfDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id_individual")
    private Integer idIndividual;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean active;

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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id_individual")
    private String nameTravelPackage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PersonIndividualGetDTO> persons;

}
