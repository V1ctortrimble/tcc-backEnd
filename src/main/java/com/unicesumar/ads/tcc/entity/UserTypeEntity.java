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
@Table(name = "USER_TYPE")
public class UserTypeEntity implements Serializable {

    @Id
    @Column(name = "ID_USER_TYPE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserType;

    @Column(name = "USER_TYPE")
    private String userType;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private List<UserEntity> userEntities;

}
