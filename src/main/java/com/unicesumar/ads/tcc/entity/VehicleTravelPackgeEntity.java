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
@Table(name = "VEHICLE_TRAVEL_PACKAGE")
public class VehicleTravelPackgeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VEHICLE_TRAVEL_PACKAGE")
    private Integer idVehicleTravelPackge;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VEHICLE")
    private List<VehicleEntity> vehicleEntities;

}
