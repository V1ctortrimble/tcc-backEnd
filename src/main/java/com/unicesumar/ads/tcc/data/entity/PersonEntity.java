package com.unicesumar.ads.tcc.data.entity;

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
@Table(name = "PERSON")
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSON")
    private Integer idPerson;

    @Column(name = "ACTIVE")
    private Boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade=CascadeType.PERSIST)
    private List<ContactEntity> contacts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade=CascadeType.PERSIST)
    private List<AdressEntity> adresses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade=CascadeType.PERSIST)
    private List<BankDetailsEntity> banksDetails;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade=CascadeType.PERSIST)
    private List<HostingEntity> hostings;

}
