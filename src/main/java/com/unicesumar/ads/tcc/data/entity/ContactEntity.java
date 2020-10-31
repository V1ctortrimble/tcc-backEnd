package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CONTACT")
public class ContactEntity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTACT")
    private Integer idContact;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSON")
    private PersonEntity person;

    @Getter
    @Setter
    @Column(name = "PHONE")
    private String phone;

    @Getter
    @Setter
    @Column(name = "CELL_PHONE")
    private String cellPhone;

    @Getter
    @Setter
    @Column(name = "EMAIL")
    private String email;

    @Getter
    @Setter
    @Column(name = "CELL_WHATS")
    private Boolean cellwhats;

}
