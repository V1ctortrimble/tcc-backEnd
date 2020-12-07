package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "INDIVIDUAL")
public class IndividualEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INDIVIDUAL")
    private Integer idIndividual;

    @Column(name = "ACTIVE")
    private Boolean active;

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

    @OneToOne(mappedBy = "individual", cascade=CascadeType.ALL)
    private PersonEntity personEntity;

    @OneToOne(mappedBy = "individual", cascade=CascadeType.ALL)
    private UsersEntity usersEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "individual")
    private List<CompanyPartnerEntity> companyPartners;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "individual" )
    private List<PassengerTravelContractEntity> passengerTravelContracts;

}
