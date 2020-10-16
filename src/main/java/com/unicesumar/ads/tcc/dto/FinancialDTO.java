package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinancialDTO {

    @JsonProperty("id_financial")
    private Integer idFinancial;

    @JsonProperty("travel_contracts")
    private TravelContractDTO contractDTO;

    @JsonProperty("payment_methods")
    private PaymentMethodDTO paymentMethodDTO;

    @JsonProperty("installment")
    private Integer installment;

    @JsonProperty("total_installment")
    private Integer totalInstallment;

    @JsonProperty("value_installment")
    private BigDecimal valueInstallment;

    @JsonProperty("due_date")
    private LocalDate dueDate;

}