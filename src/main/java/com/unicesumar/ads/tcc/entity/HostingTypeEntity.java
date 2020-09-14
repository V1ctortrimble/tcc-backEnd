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
@Table(name = "HOSTING_TYPE")
public class HostingTypeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOSTING_TYPE")
    private Integer idHostingType;

    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HOSTING")
    private List<HostingEntity> hostingEntities;

}
