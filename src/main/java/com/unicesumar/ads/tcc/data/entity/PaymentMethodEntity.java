package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PAYMENT_METHOD")
public class PaymentMethodEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAYMENT_METHOD")
    private Integer idPaymentMethod;

    @Getter
    @Setter
    @Column(name = "NAME_PAYMENT_METHOD")
    private String namePaymentMethod;

}
