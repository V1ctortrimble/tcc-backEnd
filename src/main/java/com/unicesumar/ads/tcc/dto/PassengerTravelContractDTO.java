package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.entity.IndividualEntity;
import com.unicesumar.ads.tcc.entity.TravelContractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerTravelContractDTO {

    @JsonProperty("id_passenger_travel_contract")
    private Integer idPassengerTravelContract;

    @JsonProperty("contracted_passenger")
    private Boolean contractedPassenger;

    @JsonProperty("paying_passenger")
    private Boolean payingPassenger;

    @JsonProperty("individual")
    private IndividualDTO individual;

    @JsonProperty("travel_contract")
    private TravelContractDTO travelContract;

}