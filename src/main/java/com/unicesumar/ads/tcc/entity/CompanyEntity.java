package com.unicesumar.ads.tcc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COMPANY")
public class CompanyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPANY")
    private Integer idCompany;

    @Column(name = "SOCIAL_REASON")
    private String socialReason;

    @Column(name = "FANTASY_NAME")
    private String fantasyName;

    @Column(name = "STATE_REGIS")
    private String stateRegis;

    @Column(name = "OPEN_DATE")
    private LocalDate openDate;

    @Column(name = "ACTIVE")
    private Boolean active;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VEHICLE")
    private List<VehicleEntity> vehicleEntities;

    @OneToOne
    private PersonEntity personEntity;

}