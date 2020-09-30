package com.unicesumar.ads.tcc.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMPANY_SYSTEM")
public class CompanySystemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPANY_SYSTEM")
    private Integer idCompanySystem;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY")
    private CompanyEntity company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companySystem")
    private List<CompanyPartnerEntity> companyPartners;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companySystem")
    private List<UsersEntity> users;

}
