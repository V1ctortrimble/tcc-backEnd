package com.unicesumar.ads.tcc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "INDIVIDUAL")
public class IndividualEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INDIVIDUAL")
    private Integer idIndividual;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSON")
    private PersonDTO person;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "RG")
    private String rg;

    @Column(name = "NAME_INDIVIDUAL")
    private String nameIndividual;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "ACTIVE")
    private Boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "individual")
    private List<CompanyPartnerEntity> companyPartners;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "individual" )
    private List<PassengerTravelContractDTO> passengerTravelContracts;

}
