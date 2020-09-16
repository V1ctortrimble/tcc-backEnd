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
@Table(name = "BANK_DETAILS")
public class BankDetailsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BANK_DETAILS")
    private Integer idBankDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSON")
    private PersonEntity person;

    @Column(name = "BANK")
    private String bank;

    @Column(name = "AGENCY")
    private String agency;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "DIGIT")
    private String digit;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "ACTIVE")
    private Boolean active;

}
