package com.unicesumar.ads.tcc.data.entity;

import lombok.*;
import org.springframework.lang.NonNullFields;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERSON")
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSON")
    private Integer idPerson;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_INDIVIDUAL")
    private IndividualEntity individual;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ID_COMPANY")
    private CompanyEntity company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade=CascadeType.ALL)
    private List<ContactEntity> contacts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade=CascadeType.ALL)
    private List<AdressEntity> adresses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade=CascadeType.ALL)
    private List<BankDetailsEntity> banksDetails;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private List<HostingEntity> hostings;

    @PostPersist
    public void setPerson() {
        if(adresses != null) {
            this.adresses.forEach(a -> a.setPerson(this));
        }
        this.contacts.forEach(c -> c.setPerson(this));

        if(banksDetails != null){
            this.banksDetails.forEach(b -> b.setPerson(this));
        }
    }
}
