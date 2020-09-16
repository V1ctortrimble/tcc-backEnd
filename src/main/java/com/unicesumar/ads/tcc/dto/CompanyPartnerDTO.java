package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.entity.CompanySystemEntity;
import com.unicesumar.ads.tcc.entity.IndividualEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyPartnerDTO {

    @JsonProperty("id_company_partner")
    private Integer idCompanyPartner;

    @JsonProperty("company_system")
    private CompanySystemDTO companySystem;

    @JsonProperty("individual")
    private IndividualDTO individual;

    @JsonProperty("active")
    private Boolean active;

}