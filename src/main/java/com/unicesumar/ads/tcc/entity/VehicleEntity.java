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
@Table(name = "VEHICLE")
public class VehicleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VEHICLE")
    private Integer idVehicle;

    @Column(name = "RNTRC")
    private String rntrc;

    @ManyToOne
    @JoinColumn(name = "ID_COMPANY")
    private CompanyEntity companyEntity;

    @ManyToOne
    @JoinColumn(name = "ID_VEHICLE_TYPE")
    private VehicleTypeEntity vehicleTypeEntity;


}
