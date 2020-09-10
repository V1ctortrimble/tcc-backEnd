package com.unicesumar.ads.tcc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PESSOA_JURIDICA")
public class PessoaJuridicaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESSOA_JURIDICA")
    private Integer idPessoaJuridica;

    @OneToOne
    private PessoaEntity pessoaEntity;

    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;

    @Column(name = "NOME_FANTASIA")
    private String nomeFantasii;

    @Column(name = "INSC_ESTADUAL")
    private String inscEstadual;

    @Column(name = "DATA_ABERTURA")
    private LocalDate dataAbertura;

    @Column(name = "ATIVO")
    private Boolean ativo;

}
