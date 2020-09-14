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
@Table(name = "VEHICLE_TYPE")
public class VehicleTypeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VEHICLE_TYPE")
    private Integer idVehicleType;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "NUM_SEATS")
    private Integer numSeats;

    @Column(name = "SEATS_TYPE")
    private String seatsType;

    @Column(name = "BATHROOM")
    private Boolean bathroom;

    @Column(name = "ACCESSIBILITY")
    private Boolean accessibility;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VEHICLE")
    private List<VehicleEntity> vehicleEntities;

}
