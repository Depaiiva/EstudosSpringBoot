package io.github.Depaiiva.carApi.controller.dto;

import java.time.LocalDate;
import java.util.UUID;

import io.github.Depaiiva.carApi.model.Pessoa;

public record PessoaDTO(UUID id, String nome, LocalDate dataNascimento, String cpf) {

  public Pessoa salvar() {
    Pessoa pessoa = new Pessoa();
    pessoa.setNome(this.nome);
    pessoa.setCpf(this.cpf);
    pessoa.setDataNascimento(this.dataNascimento);
    return pessoa;
  }
}
