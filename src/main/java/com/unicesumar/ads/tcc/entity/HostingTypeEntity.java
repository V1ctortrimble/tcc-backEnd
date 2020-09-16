package com.unicesumar.ads.tcc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HOSTING_TYPE")
public class HostingTypeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOSTING_TYPE")
    private Integer idHostingType;

    @Column(name = "NAME_HOSTING_TYPE")
    private String nameHostingType;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "hostingType")
    private List<HostingEntity> hostingEntities;

}
