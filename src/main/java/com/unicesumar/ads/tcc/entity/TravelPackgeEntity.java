package com.unicesumar.ads.tcc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRAVEL_PACKAGE")
public class TravelPackgeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRAVEL_PACKAGE")
    private Integer idTravelPackge;

    @Column(name = "NAME_TRAVEL_PACKAGE")
    private String nameTravelPackge;

    @Column(name = "DESCR_TRAVEL_PACKAGE")
    private String descrTravelPackge;

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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HOSTING_TRAVEL_PACKAGE")
    private List<HostingTravelPackageEntity> hostingTravelPackageEntities;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VEHICLE_TRAVEL_PACKAGE")
    private List<VehicleTravelPackgeEntity> vehicleTravelPackgeEntities;

}
