package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CONTACT")
public class ContactEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTACT")
    private Integer idContact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSON")
    private PersonEntity person;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "CELL_PHONE")
    private String cellPhone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CELL_WHATS")
    private Boolean cellwhats;

}
