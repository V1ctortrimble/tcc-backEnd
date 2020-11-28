package com.unicesumar.ads.tcc.dto.hostingPostDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.CompanyDTO;
import com.unicesumar.ads.tcc.dto.IndividualDTO;
import com.unicesumar.ads.tcc.dto.vehicleGetDTO.CompanyGetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonPostDTO {

    private Integer idPerson;

    private IndividualDTO individual;

    private CompanyGetDTO company;
}
