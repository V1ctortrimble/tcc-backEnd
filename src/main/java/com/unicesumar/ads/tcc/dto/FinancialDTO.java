package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinancialDTO {

    @JsonProperty("id_financial")
    private Integer idFinancial;

    @JsonProperty("installment")
    private Integer installment;

    @JsonProperty("total_installment")
    private Integer totalInstallment;

    @JsonProperty("value_installment")
    private BigDecimal valueInstallment;

    @JsonProperty("due_date")
    private LocalDate dueDate;

    @JsonProperty("payment_methods")
    private List<PaymentMethodDTO> paymentMethodEntities;

    @JsonProperty("travel_contracts")
    private List<TravelContractDTO> travelContractEntities;

}