package io.github.Depaiiva.carApi.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;

import io.github.Depaiiva.carApi.exceptions.RegistroDuplicado;
import io.github.Depaiiva.carApi.model.Pessoa;
import io.github.Depaiiva.carApi.repository.PessoaRepository;

@Component
public class PessoaValidator {
  private PessoaRepository pessoaRepository;

  public PessoaValidator(PessoaRepository pessoaRepository) {
    this.pessoaRepository = pessoaRepository;
  }

  private boolean existePessoaCadastrada(Pessoa pessoa) {
    Optional<Pessoa> pessoaEncontrada = pessoaRepository.findByNomeAndDataNascimentoAndCpf(pessoa.getNome(),
        pessoa.getDataNascimento(), pessoa.getCpf());

    // caso queira cadastrar
    if (pessoa.getId() == null) {
      return pessoaEncontrada.isPresent();
    }

    // caso queira atualizar
    return !pessoa.getId().equals(pessoaEncontrada.get().getId()) && pessoaEncontrada.isPresent();
  }

  public void validar(Pessoa pessoa) {
    if (existePessoaCadastrada(pessoa)) {
      throw new RegistroDuplicado("Pessoa já cadastrada");
    }
  }
}
