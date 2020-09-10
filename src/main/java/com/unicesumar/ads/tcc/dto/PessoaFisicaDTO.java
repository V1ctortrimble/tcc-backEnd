package com.unicesumar.ads.tcc.dto;

import com.unicesumar.ads.tcc.entity.PessoaEntity;

import java.time.LocalDate;

public class PessoaFisicaDTO {

    private Integer idPessoaFisica;

    private PessoaEntity pessoaEntity;

    private String cpf;

    private String rg;

    private String nomePessoaFisica;

    private String sobrenomePessoaFisisca;

    private LocalDate dataNasc;

    private Boolean ativo;

}
