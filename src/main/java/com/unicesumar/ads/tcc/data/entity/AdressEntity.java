package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ADRESS")
public class AdressEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADRESS")
    private Integer idAdress;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSON")
    private PersonEntity person;

    @Getter
    @Setter
    @Column(name = "ADRESS")
    private String adress;

    @Getter
    @Setter
    @Column(name = "ADRESS_NUMBER")
    private Integer adressNumber;

    @Getter
    @Setter
    @Column(name = "ADDITIONAL")
    private String additional;

    @Getter
    @Setter
    @Column(name = "NEIGHBORHOOD")
    private String neighborhood;

    @Getter
    @Setter
    @Column(name = "CITY")
    private String city;

    @Getter
    @Setter
    @Column(name = "STATE")
    private String state;

    @Getter
    @Setter
    @Column(name = "ZIP_CODE")
    private String zipCode;

}