package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRAVEL_PACKAGE")
public class TravelPackageEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRAVEL_PACKAGE")
    private Integer idTravelPackage;

    @Column(name = "NAME_TRAVEL_PACKAGE")
    private String nameTravelPackage;

    @Column(name = "DESCR_TRAVEL_PACKAGE")
    private String descrTravelPackage;

    @Column(name = "DESTINATION_NAME")
    private String destinationName;

    @Column(name = "ORIGIN_NAME")
    private String originName;

    @Column(name = "ADULT_PRICE")
    private BigDecimal adultPrice;

    @Column(name = "CHILD_PRICE")
    private BigDecimal childPrice;

    @Column(name = "ROUTE")
    private String route;

    @Column(name = "PAYMENT_METHODS")
    private String paymentMethods;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "EXPECTED_START_TIME" )
    private LocalTime expectedStartTime;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "ESTIMATED_END_TIME" )
    private LocalTime estimatedEndTime;

    @Column(name = "FEATURE_TRAVEL_PACKAGE")
    private String featureTravelPackge;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Column(name = "ACCTIVE")
    private Boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "travelPackage", cascade=CascadeType.ALL)
    private List<TravelContractEntity> travelContracts;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "HOSTING_TRAVEL_PACKAGE", joinColumns =
            {@JoinColumn(name = "ID_TRAVEL_PACKAGE" )},
            inverseJoinColumns = {@JoinColumn( name = "ID_HOSTING")})
    private List<HostingEntity> hostings;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "VEHICLE_TRAVEL_PACKAGE", joinColumns =
            {@JoinColumn(name = "ID_TRAVEL_PACKAGE" )}, inverseJoinColumns =
            {@JoinColumn( name = "ID_VEHICLE")})
    private List<VehicleEntity> vehicles;

}
