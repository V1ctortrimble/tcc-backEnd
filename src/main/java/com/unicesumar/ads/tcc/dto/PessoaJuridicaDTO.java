package com.unicesumar.ads.tcc.dto;

import com.unicesumar.ads.tcc.entity.PessoaEntity;

import java.time.LocalDate;

public class PessoaJuridicaDTO {

    private Integer idPessoaJuridica;

    private PessoaEntity pessoaEntity;

    private String razaoSocial;

    private String nomeFantasii;

    private String inscEstadual;

    private LocalDate dataAbertura;

    private Boolean ativo;

}
