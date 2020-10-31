package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMPANY_SYSTEM")
public class CompanySystemEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPANY_SYSTEM")
    private Integer idCompanySystem;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companySystem")
    private List<CompanyPartnerEntity> companyPartners;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companySystem")
    private List<UsersEntity> users;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY")
    private CompanyEntity company;

}
