package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VEHICLE")
public class VehicleEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VEHICLE")
    private Integer idVehicle;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_COMPANY")
    private CompanyEntity company;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_VEHICLE_TYPE")
    private VehicleTypeEntity vehicleType;

    @Getter
    @Setter
    @Column(name = "RNTRC")
    private String rntrc;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "vehicles", cascade=CascadeType.ALL)
    private List<TravelPackageEntity> travelPackages;

}
