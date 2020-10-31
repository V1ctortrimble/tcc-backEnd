package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HOSTING")
public class HostingEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOSTING")
    private Integer idHosting;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_PERSON")
    private PersonEntity person;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_HOSTING_TYPE")
    private HostingTypeEntity hostingType;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_ADRESS")
    private AdressEntity adress;

    @Getter
    @Setter
    @Column(name = "TOURISM_REGIS")
    private String tourismRegis;

    @Getter
    @Setter
    @Column(name = "QUANTITY_PERSON")
    private Integer quantityPerson;

    @Getter
    @Setter
    @Column(name = "FEATURES_HOSTING")
    private String featuresHosting;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "hostings", cascade=CascadeType.ALL)
    private List<TravelPackageEntity> travelPackages;

}
