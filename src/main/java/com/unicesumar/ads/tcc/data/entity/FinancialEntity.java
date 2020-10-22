package com.unicesumar.ads.tcc.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FINANCIAL")
public class FinancialEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FINANCIAL")
    private Integer idFinancial;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_TRAVEL_CONTRACT")
    private TravelContractEntity travelContract;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_PAYMENT_METHOD")
    private PaymentMethodEntity paymentMethod;

    @Column(name = "INSTALLMENT")
    private Integer installment;

    @Column(name = "TOTAL_INSTALLMENTS")
    private Integer totalInstallment;

    @Column(name = "VALUE_INSTALLMENT")
    private BigDecimal valueInstallment;

    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

}