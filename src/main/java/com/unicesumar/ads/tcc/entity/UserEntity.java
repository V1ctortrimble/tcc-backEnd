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
@Table(name = "USERS")
public class UserEntity implements Serializable {

    @Id
    @Column(name = "ID_USERS")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @OneToOne
    @JoinColumn(name = "ID_INDIVIDUAL")
    private IndividualEntity individualEntity;

    @ManyToOne
    @JoinColumn(name = "ID_COMPANY_SYSTEM")
    private CompanySystemEntity companySystemEntity;

    @ManyToOne
    @JoinColumn(name = "ID_USER_TYPE")
    private UserTypeEntity userTypeEntity;

    @Column(name = "PASSWORD")
    private String password;
}
