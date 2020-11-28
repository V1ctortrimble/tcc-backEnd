package com.unicesumar.ads.tcc.dto.hostingPutDTO;

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
public class PersonPutDTO {

    private Integer idPerson;

    private IndividualDTO individual;

    private CompanyGetDTO company;
}
