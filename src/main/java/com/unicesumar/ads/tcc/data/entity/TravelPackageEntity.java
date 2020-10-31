package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRAVEL_PACKAGE")
public class TravelPackageEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRAVEL_PACKAGE")
    private Integer idTravelPackge;

    @Getter
    @Setter
    @Column(name = "NAME_TRAVEL_PACKAGE")
    private String nameTravelPackge;

    @Getter
    @Setter
    @Column(name = "DESCR_TRAVEL_PACKAGE")
    private String descrTravelPackge;

    @Getter
    @Setter
    @Column(name = "DESTINATION_NAME")
    private String destinationName;

    @Getter
    @Setter
    @Column(name = "ORIGIN_NAME")
    private String originName;

    @Getter
    @Setter
    @Column(name = "ADULT_PRICE")
    private BigDecimal adultPrice;

    @Getter
    @Setter
    @Column(name = "CHILD_PRICE")
    private BigDecimal childPrice;

    @Getter
    @Setter
    @Column(name = "ROUTE")
    private String route;

    @Getter
    @Setter
    @Column(name = "PAYMENT_METHODS")
    private String paymentMethods;

    @Getter
    @Setter
    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Getter
    @Setter
    @Column(name = "EXPECTED_START_TIME" )
    private LocalTime expectedStartTime;

    @Getter
    @Setter
    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Getter
    @Setter
    @Column(name = "ESTIMATED_END_TIME" )
    private LocalTime estimatedEndTime;

    @Getter
    @Setter
    @Column(name = "FEATURE_TRAVEL_PACKAGE")
    private String featureTravelPackge;

    @Getter
    @Setter
    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "travelPackage", cascade=CascadeType.ALL)
    private List<TravelContractEntity> travelContracts;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "HOSTING_TRAVEL_PACKAGE", joinColumns =
            {@JoinColumn( name = "ID_HOSTING")}, inverseJoinColumns =
            {@JoinColumn(name = "ID_TRAVEL_PACKAGE" )})
    private List<HostingEntity> hostings;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "VEHICLE_TRAVEL_PACKAGE", joinColumns =
            {@JoinColumn( name = "ID_VEHICLE")}, inverseJoinColumns =
            {@JoinColumn(name = "ID_TRAVEL_PACKAGE" )})
    private List<VehicleEntity> vehicles;

}
