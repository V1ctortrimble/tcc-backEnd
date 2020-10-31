package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "INDIVIDUAL")
public class IndividualEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INDIVIDUAL")
    private Integer idIndividual;

    @Getter
    @Setter
    @Column(name = "CPF")
    private String cpf;

    @Getter
    @Setter
    @Column(name = "RG")
    private String rg;

    @Getter
    @Setter
    @Column(name = "NAME_INDIVIDUAL")
    private String nameIndividual;

    @Getter
    @Setter
    @Column(name = "LAST_NAME")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "individual")
    private List<CompanyPartnerEntity> companyPartners;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "individual" )
    private List<PassengerTravelContractEntity> passengerTravelContracts;

}
