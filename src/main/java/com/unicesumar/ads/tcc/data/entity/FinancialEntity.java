package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FINANCIAL")
public class FinancialEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FINANCIAL")
    private Integer idFinancial;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_TRAVEL_CONTRACT")
    private TravelContractEntity travelContract;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_PAYMENT_METHOD")
    private PaymentMethodEntity paymentMethod;

    @Getter
    @Setter
    @Column(name = "INSTALLMENT")
    private Integer installment;

    @Getter
    @Setter
    @Column(name = "TOTAL_INSTALLMENTS")
    private Integer totalInstallment;

    @Getter
    @Setter
    @Column(name = "VALUE_INSTALLMENT")
    private BigDecimal valueInstallment;

    @Getter
    @Setter
    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

}