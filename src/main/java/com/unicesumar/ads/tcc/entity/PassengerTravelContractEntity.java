package com.unicesumar.ads.tcc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PASSENGER_TRAVEL_CONTRACT")
public class PassengerTravelContractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PASSENGER_TRAVEL_CONTRACT")
    private Integer idPassengerTravelContract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_INDIVIDUAL")
    private IndividualEntity individual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TRAVEL_CONTRACT")
    private TravelContractEntity travelContract;

    @Column(name = "CONTRACTED_PASSENGER")
    private Boolean contractedPassenger;

    @Column(name = "PAYING_PASSENGER")
    private Boolean payingPassenger;

}
