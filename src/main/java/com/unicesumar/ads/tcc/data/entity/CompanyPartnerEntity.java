package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMPANY_PARTNER")
public class CompanyPartnerEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPANY_PARTNER")
    private Integer idCompanyPartner;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_COMPANY_SYSTEM")
    private CompanySystemEntity companySystem;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_INDIVIDUAL")
    private IndividualEntity individual;

    @Getter
    @Setter
    @Column(name = "ACTIVE")
    private Boolean active;
}
