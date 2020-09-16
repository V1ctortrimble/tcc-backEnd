package com.unicesumar.ads.tcc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ADRESS")
public class AdressEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADRESS")
    private Integer idAdress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSON")
    private PersonEntity person;

    @Column(name = "ADRESS")
    private String adress;

    @Column(name = "ADRESS_NUMBER")
    private Integer adressNumber;

    @Column(name = "ADDITIONAL")
    private String additional;

    @Column(name = "NEIGHBORHOOD")
    private String neighborhood;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP_CODE")
    private String zipCode;

}