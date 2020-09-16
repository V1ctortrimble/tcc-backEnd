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
@Table(name = "PERSON")
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSON")
    private Integer idPerson;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personEntity")
    private List<ContactEntity> contactEntities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personEntity")
    private List<AdressEntity> adressEntities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personEntity")
    private List<BankDetailsEntity> bankDetailsEntities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personEntity")
    private List<HostingEntity> hostingEntities;

}
