package com.unicesumar.ads.tcc.data.entity;

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
@Table(name = "RECOVERY_SENHA")
public class RecoveryPassEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECOVERY_PASS")
    private Integer id;

    @Column(name = "CODE")
    private String code;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private UserEntity userEntity;


}
