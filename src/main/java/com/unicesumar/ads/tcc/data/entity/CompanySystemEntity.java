package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMPANY_SYSTEM")
public class CompanySystemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPANY_SYSTEM")
    private Integer idCompanySystem;

    @Column(name = "ACTIVE")
    private Boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companySystem")
    private List<CompanyPartnerEntity> companyPartners;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companySystem")
    private List<UsersEntity> users;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY")
    private CompanyEntity company;

}
