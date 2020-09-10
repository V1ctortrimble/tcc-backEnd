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
@Table(name = "PESSOA_FISICA")
public class PessoaFisicaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESSOA_FISICA")
    private Integer idPessoaFisica;

    @OneToOne
    private PessoaEntity pessoaEntity;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "RG")
    private String rg;

    @Column(name = "NOME_PESSOA_FISICA")
    private String nomePessoaFisica;

    @Column(name = "SOBRENOME_PESSOA_FISICA")
    private String sobrenomePessoaFisisca;

    @Column(name = "DATA_NASC")
    private LocalDate dataNasc;

    @Column(name = "ATIVO")
    private Boolean ativo;

}
