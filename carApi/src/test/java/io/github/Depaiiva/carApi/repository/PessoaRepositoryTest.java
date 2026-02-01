package io.github.Depaiiva.carApi.repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.Depaiiva.carApi.model.Pessoa;

@SpringBootTest
public class PessoaRepositoryTest {

  @Autowired
  PessoaRepository repository;

  @Test
  public void salvarPessoaTest() {
    Pessoa pessoa = new Pessoa();
    pessoa.setNome("Carlos");
    pessoa.setCpf("082.893.941-10");
    pessoa.setDataNascimento(LocalDate.of(2003, 9, 23));
    pessoa.toString();
    var pessoaSalva = repository.save(pessoa);
    System.out.println("Pessoa salva: " + pessoaSalva.toString());
  }

  @Test
  public void editarPessoaTest() {
    var id = UUID.fromString("62a5018b-5045-4390-8554-7bfae6fb67e7");
    Optional<Pessoa> possivelPessoa = repository.findById(id);

    if (possivelPessoa.isPresent()) {
      Pessoa pessoa = possivelPessoa.get();
      System.out.println("Dados antigos de " + pessoa.getNome() + ": " + pessoa.toString());

      pessoa.setNome("Carlos Henrique");

      System.out.println("Dados novos de " + pessoa.getNome() + ": " + pessoa.toString());
      repository.save(pessoa);
    }
  }

  @Test
  void deletarPessoa() {
    var pessoa = repository.findById(UUID.fromString("ca434379-3e7c-40c9-924d-db236f40a22c")).orElse(null);
    repository.delete(pessoa);
  }
}
