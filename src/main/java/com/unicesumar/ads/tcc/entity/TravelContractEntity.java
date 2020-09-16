package com.unicesumar.ads.tcc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRAVEL_CONTRACT")
public class TravelContractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRAVEL_CONTRACT")
    private Integer idTravelContract;

    @Column(name = "BOARDING_LOCATION")
    private String boardingLocation;

    @Column(name = "BOARDING_TIME")
    private LocalTime boardingTime;

    @Column(name = "ISSUE_DATE")
    private LocalDateTime issueDate;

    @Column(name = "TOTAL_CONTRACT_AMOUNT")
    private BigDecimal totalContractAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TRAVEL_PACKAGE")
    private TravelPackgeEntity travelPackgeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY")
    private CompanyEntity companyEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "travelContractEntity")
    private List<PassengerTravelContractEntity> passengerTravelContractEntities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "travelContractEntity")
    private List<FinancialEntity> financialEntities;

}
