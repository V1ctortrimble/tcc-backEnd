package com.unicesumar.ads.tcc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HOSTING")
public class HostingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOSTING")
    private Integer idHosting;

    @Column(name = "TOURISM_REGIS")
    private String tourismRegis;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "COMPLEMENT")
    private String complement;

    @Column(name = "NEIGHBORHOOD")
    private String neighborhood;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "QUANTITY_PERSON")
    private Integer quantityPerson;

    @Column(name = "FEATURES_HOSTING")
    private Integer featuresHosting;

    @ManyToOne
    @JoinColumn(name = "ID_PERSON")
    private PersonEntity personEntity;

    @OneToOne
    @JoinColumn(name = "ID_HOSTING_TYPE")
    private HostingTypeEntity hostingTypeEntity;

    @ManyToMany(mappedBy = "hostingEntities")
    private List<TravelPackgeEntity> travelPackgeEntities;

}
