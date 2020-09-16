package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentMethodDTO {

    @JsonProperty("id_payment_method")
    private Integer idPaymentMethod;

    @JsonProperty("name_payment_method")
    private String namePaymentMethod;

}