package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HOSTING_TYPE")
public class HostingTypeEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOSTING_TYPE")
    private Integer idHostingType;

    @Getter
    @Setter
    @Column(name = "NAME_HOSTING_TYPE")
    private String nameHostingType;

    @Getter
    @Setter
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "hostingType", cascade=CascadeType.ALL)
    private List<HostingEntity> hostingEntities;

}
