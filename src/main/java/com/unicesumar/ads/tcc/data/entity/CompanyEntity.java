package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMPANY")
public class CompanyEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPANY")
    private Integer idCompany;

    @Getter
    @Setter
    @Column(name = "SOCIAL_REASON")
    private String socialReason;

    @Getter
    @Setter
    @Column(name = "FANTASY_NAME")
    private String fantasyName;

    @Getter
    @Setter
    @Column(name = "CNPJ")
    private String cnpj;

    @Getter
    @Setter
    @Column(name = "STATE_REGIS")
    private String stateRegis;

    @Getter
    @Setter
    @Column(name = "OPEN_DATE")
    private LocalDate openDate;

    @Getter
    @Setter
    @Column(name = "ACTIVE")
    private Boolean active;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<VehicleEntity> vehicles;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<TravelContractEntity> travelContracts;

}
