package io.github.Depaiiva.carApi.repository;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.Depaiiva.carApi.model.Carro;
import io.github.Depaiiva.carApi.model.Marca;
import io.github.Depaiiva.carApi.model.Modelo;
import io.github.Depaiiva.carApi.model.Pessoa;

@SpringBootTest
class CarroRepositoryTest {

  @Autowired
  CarroRepository carroRepository;

  @Autowired
  PessoaRepository pessoaRepository;

  @Test
  void salvarCarroTest() {
    Carro carro = new Carro();
    carro.setNome("Civicão");
    carro.setMarca(Marca.HONDA);
    carro.setModelo(Modelo.Sedan);
    carro.setAno(LocalDate.of(2026, 9, 1));
    carro.setTipo("Hibrido");

    Pessoa pessoa = pessoaRepository.findById(UUID.fromString("62a5018b-5045-4390-8554-7bfae6fb67e7")).orElse(null);
    carro.setDono(pessoa);
    carroRepository.save(carro);
  }

  @Test
  void salvarCarroCascadeTest() {
    Carro carro = new Carro();
    carro.setNome("Civicão");
    carro.setMarca(Marca.HONDA);
    carro.setModelo(Modelo.Sedan);
    carro.setAno(LocalDate.of(2026, 9, 1));
    carro.setTipo("Hibrido");

    Pessoa pessoa = new Pessoa();
    pessoa.setNome("Mariana Solano");
    pessoa.setCpf("179.109.797-97");
    pessoa.setDataNascimento(LocalDate.of(2004, 1, 16));

    carro.setDono(pessoa);

    carroRepository.save(carro);

  }
}
