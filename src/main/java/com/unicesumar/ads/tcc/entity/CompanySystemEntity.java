package com.unicesumar.ads.tcc.entity;

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

    @OneToOne
    private CompanyEntity companyEntity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY_PARTNER")
    private List<CompanyPartnerEntity> companyPartnerEntities;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private List<UserEntity> userEntities;

}