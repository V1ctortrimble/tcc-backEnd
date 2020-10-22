package com.unicesumar.ads.tcc.dto.personDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.PostPersist;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonIndividualDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean active;

    private IndividualDTO individual;

    private List<ContactDTO> contacts;

    private List<AdressDTO> adresses;

    @JsonProperty("banks_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<BankDetailsDTO> banksDetails;

}