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
@Table(name = "VEHICLE")
public class VehicleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VEHICLE")
    private Integer idVehicle;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_COMPANY")
    private CompanyEntity company;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_VEHICLE_TYPE")
    private VehicleTypeEntity vehicleType;

    @Column(name = "RNTRC")
    private String rntrc;

    @Column(name = "ACTIVE")
    private Boolean active;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "vehicles", cascade=CascadeType.ALL)
    private List<TravelPackageEntity> travelPackages;

}
