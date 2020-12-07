package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRAVEL_CONTRACT")
public class TravelContractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRAVEL_CONTRACT")
    private Integer idTravelContract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TRAVEL_PACKAGE")
    private TravelPackageEntity travelPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY")
    private CompanyEntity company;

    @Column(name = "BOARDING_LOCATION")
    private String boardingLocation;

    @Column(name = "LANDING_LOCATION")
    private String landingLocation;

    @Column(name = "BOARDING_TIME")
    private LocalTime boardingTime;

    @Column(name = "ISSUE_DATE")
    private LocalDate issueDate;

    @Column(name = "TOTAL_CONTRACT_AMOUNT")
    private BigDecimal totalContractAmount;

    @Column(name = "ACTIVE")
    private Boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "travelContract", cascade=CascadeType.ALL)
    private List<PassengerTravelContractEntity> passengerTravelContracts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "travelContract", cascade=CascadeType.ALL)
    private List<FinancialEntity> financials;

}
