package io.github.Depaiiva.carApi.controller.dto;

import java.time.LocalDate;
import java.util.UUID;

import io.github.Depaiiva.carApi.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PessoaDTO(
    UUID id,

    @NotBlank(message = "campo invalido") @Size(min = 2, max = 50, message = "Quantidade de caracteres fora do padrão") String nome,

    @NotNull(message = "campo invalido") LocalDate dataNascimento,

    @NotBlank(message = "campo invalido") String cpf) {

  public Pessoa salvar() {
    Pessoa pessoa = new Pessoa();
    pessoa.setNome(this.nome);
    pessoa.setCpf(this.cpf);
    pessoa.setDataNascimento(this.dataNascimento);
    return pessoa;
  }
}
