package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRAVEL_CONTRACT")
public class TravelContractEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRAVEL_CONTRACT")
    private Integer idTravelContract;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_TRAVEL_PACKAGE")
    private TravelPackageEntity travelPackage;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_COMPANY")
    private CompanyEntity company;

    @Getter
    @Setter
    @Column(name = "BOARDING_LOCATION")
    private String boardingLocation;

    @Getter
    @Setter
    @Column(name = "BOARDING_TIME")
    private LocalTime boardingTime;

    @Getter
    @Setter
    @Column(name = "ISSUE_DATE")
    private LocalDateTime issueDate;

    @Getter
    @Setter
    @Column(name = "TOTAL_CONTRACT_AMOUNT")
    private BigDecimal totalContractAmount;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "travelContract", cascade=CascadeType.ALL)
    private List<PassengerTravelContractEntity> passengerTravelContracts;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "travelContract", cascade=CascadeType.ALL)
    private List<FinancialEntity> financials;

}
