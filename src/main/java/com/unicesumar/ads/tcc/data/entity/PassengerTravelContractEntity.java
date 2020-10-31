package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PASSENGER_TRAVEL_CONTRACT")
public class PassengerTravelContractEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PASSENGER_TRAVEL_CONTRACT")
    private Integer idPassengerTravelContract;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_INDIVIDUAL")
    private IndividualEntity individual;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_TRAVEL_CONTRACT")
    private TravelContractEntity travelContract;

    @Getter
    @Setter
    @Column(name = "CONTRACTED_PASSENGER")
    private Boolean contractedPassenger;

    @Getter
    @Setter
    @Column(name = "PAYING_PASSENGER")
    private Boolean payingPassenger;

}
