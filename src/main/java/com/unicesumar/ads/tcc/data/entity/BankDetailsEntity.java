package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BANK_DETAILS")
public class BankDetailsEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BANK_DETAILS")
    private Integer idBankDetails;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSON")
    private PersonEntity person;

    @Getter
    @Setter
    @Column(name = "BANK")
    private String bank;

    @Getter
    @Setter
    @Column(name = "AGENCY")
    private String agency;

    @Getter
    @Setter
    @Column(name = "ACCOUNT")
    private String account;

    @Getter
    @Setter
    @Column(name = "DIGIT")
    private String digit;

    @Getter
    @Setter
    @Column(name = "OPERATION")
    private String operation;

    @Getter
    @Setter
    @Column(name = "ACTIVE")
    private Boolean active;

}
