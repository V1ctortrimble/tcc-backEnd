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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CONTATO")
    private List<ContactEntity> contactEntities;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ENDERECO")
    private List<AdressEntity> enderecoEntities;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BANK_DETAILS")
    private List<BankDetailsEntity> bankDetailsEntities;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HOSTING")
    private List<HostingEntity> hostingEntities;

}
