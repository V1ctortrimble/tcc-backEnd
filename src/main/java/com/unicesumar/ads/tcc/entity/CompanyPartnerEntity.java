package com.unicesumar.ads.tcc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMPANY_PARTNER")
public class CompanyPartnerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPANY_PARTNER")
    private Integer idCompanyPartner;

    @Column(name = "ACTIVE")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "ID_COMPANY_SYSTEM")
    private CompanySystemEntity companySystemEntity;

    @ManyToOne
    @JoinColumn(name = "ID_INDIVIDUAL")
    private IndividualEntity individualEntity;
}
