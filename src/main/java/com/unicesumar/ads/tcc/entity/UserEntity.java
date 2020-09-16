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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_INDIVIDUAL")
    private IndividualEntity individual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANY_SYSTEM")
    private CompanySystemEntity companySystem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER_TYPE")
    private UserTypeEntity userType;

    @Column(name = "PASSWORD")
    private String password;
}
