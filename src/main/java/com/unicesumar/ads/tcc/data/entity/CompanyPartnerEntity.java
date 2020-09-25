package com.unicesumar.ads.tcc.data.entity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY_SYSTEM")
    private CompanySystemEntity companySystem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_INDIVIDUAL")
    private IndividualEntity individual;

    @Column(name = "ACTIVE")
    private Boolean active;
}
