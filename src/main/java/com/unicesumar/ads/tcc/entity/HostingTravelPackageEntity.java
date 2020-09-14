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
@Table(name = "HOSTING_TRAVEL_PACKAGE")
public class HostingTravelPackageEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOSTING_TRAVEL_PACKAGE")
    private Integer idHostingTravelPackage;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HOSTING")
    private List<HostingEntity> hostingEntities;

}
