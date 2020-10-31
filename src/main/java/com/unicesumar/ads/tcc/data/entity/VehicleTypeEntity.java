package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VEHICLE_TYPE")
public class VehicleTypeEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VEHICLE_TYPE")
    private Integer idVehicleType;

    @Getter
    @Setter
    @Column(name = "NAME_VEHICLE_TYPE")
    private String nameVehicleType;

    @Getter
    @Setter
    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Getter
    @Setter
    @Column(name = "MODEL")
    private String model;

    @Getter
    @Setter
    @Column(name = "NUM_SEATS")
    private Integer numSeats;

    @Getter
    @Setter
    @Column(name = "SEATS_TYPE")
    private String seatsType;

    @Getter
    @Setter
    @Column(name = "BATHROOM")
    private Boolean bathroom;

    @Getter
    @Setter
    @Column(name = "ACCESSIBILITY")
    private Boolean accessibility;

    @Getter
    @Setter
    @Column(name = "DESCRIPTION")
    private String description;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicleType", cascade=CascadeType.ALL)
    private List<VehicleEntity> vehicles;

}
