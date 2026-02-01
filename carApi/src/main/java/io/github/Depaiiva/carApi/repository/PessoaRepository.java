package io.github.Depaiiva.carApi.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.Depaiiva.carApi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

  List<Pessoa> findByNome(String nome);

  List<Pessoa> findByCpf(String cpf);

  List<Pessoa> findByNomeAndCpf(String nome, String cpf);

  Optional<Pessoa> findByNomeAndDataNascimentoAndCpf(String nome, LocalDate dataNascimento, String cpf);
}
