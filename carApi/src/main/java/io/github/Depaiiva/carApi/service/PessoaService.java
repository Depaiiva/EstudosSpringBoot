package io.github.Depaiiva.carApi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.Depaiiva.carApi.exceptions.RegistroTemCarro;
import io.github.Depaiiva.carApi.model.Pessoa;
import io.github.Depaiiva.carApi.repository.CarroRepository;
import io.github.Depaiiva.carApi.repository.PessoaRepository;
import io.github.Depaiiva.carApi.validator.PessoaValidator;

@Service
public class PessoaService {

  private final PessoaRepository pessoaRepository;
  private final PessoaValidator pessoaValidator;
  private final CarroRepository carroRepository;

  public PessoaService(PessoaRepository pessoaRepository, PessoaValidator pessoaValidator,
      CarroRepository carroRepository) {
    this.pessoaRepository = pessoaRepository;
    this.pessoaValidator = pessoaValidator;
    this.carroRepository = carroRepository;
  }

  public void salvar(Pessoa pessoa) {
    pessoaValidator.validar(pessoa);
    pessoaRepository.save(pessoa);
  }

  public Optional<Pessoa> obterPessoa(UUID idPessoa) {
    return pessoaRepository.findById(idPessoa);
  }

  public void deletarPessoa(Pessoa pessoa) {
    if (pessoaTemCarro(pessoa)) {
      throw new RegistroTemCarro("ERRO. Pessoa tem carro, não pode ser excluida");
    }
    pessoaRepository.delete(pessoa);
  }

  public List<Pessoa> pesquisar(String nome, String cpf) {
    if (nome != null && cpf != null)
      return pessoaRepository.findByNomeAndCpf(nome, cpf);

    if (nome != null)
      return pessoaRepository.findByNome(nome);

    if (cpf != null)
      return pessoaRepository.findByCpf(cpf);

    return pessoaRepository.findAll();
  }

  public void atualizar(Pessoa pessoa) {
    pessoaValidator.validar(pessoa);
    pessoaRepository.save(pessoa);
  }

  public boolean pessoaTemCarro(Pessoa pessoa) {
    return carroRepository.existsByDono(pessoa);
  }
}
