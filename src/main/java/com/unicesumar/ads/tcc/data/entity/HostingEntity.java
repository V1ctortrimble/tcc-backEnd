package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HOSTING")
public class HostingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOSTING")
    private Integer idHosting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSON")
    private PersonEntity person;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_HOSTING_TYPE")
    private HostingTypeEntity hostingType;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_ADRESS")
    private AdressEntity adress;

    @Column(name = "TOURISM_REGIS")
    private String tourismRegis;

    @Column(name = "QUANTITY_PERSON")
    private Integer quantityPerson;

    @Column(name = "FEATURES_HOSTING")
    private String featuresHosting;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "hostings", cascade=CascadeType.ALL)
    private List<TravelPackageEntity> travelPackages;

}
