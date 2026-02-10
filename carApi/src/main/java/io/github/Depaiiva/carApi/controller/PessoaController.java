package io.github.Depaiiva.carApi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.Depaiiva.carApi.controller.dto.ErroResposta;
import io.github.Depaiiva.carApi.controller.dto.PessoaDTO;
import io.github.Depaiiva.carApi.exceptions.RegistroDuplicado;
import io.github.Depaiiva.carApi.exceptions.RegistroTemCarro;
import io.github.Depaiiva.carApi.model.Pessoa;
import io.github.Depaiiva.carApi.service.PessoaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

  private final PessoaService pessoaService;

  public PessoaController(PessoaService pessoaService) {
    this.pessoaService = pessoaService;
  }

  @PostMapping
  public ResponseEntity<Object> salvarPessoa(@RequestBody @Valid PessoaDTO pessoa) {
    try {
      Pessoa p = pessoa.salvar();
      pessoaService.salvar(p);
      URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(p.getId())
          .toUri();
      return ResponseEntity.created(location).build();
    } catch (RegistroDuplicado e) {
      var erroDTO = ErroResposta.conflito(e.getMessage());
      return ResponseEntity.status(erroDTO.status()).body(erroDTO);
    }
  }

  @GetMapping("{id}")
  public ResponseEntity<PessoaDTO> obterPessoa(@PathVariable("id") String id) {
    UUID idPessoa = UUID.fromString(id);
    Optional<Pessoa> p = pessoaService.obterPessoa(idPessoa);

    if (p.isPresent()) {
      Pessoa pessoa = p.get();
      PessoaDTO dto = new PessoaDTO(pessoa.getId(),
          pessoa.getNome(),
          pessoa.getDataNascimento(),
          pessoa.getCpf());
      return ResponseEntity.ok(dto);
    }

    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> deletarPessoa(@PathVariable("id") String id) {
    try {
      UUID idPessoa = UUID.fromString(id);
      Optional<Pessoa> obterPessoa = pessoaService.obterPessoa(idPessoa);
      if (obterPessoa.isPresent()) {
        pessoaService.deletarPessoa(obterPessoa.get());
        return ResponseEntity.noContent().build();
      }
      return ResponseEntity.notFound().build();
    } catch (RegistroTemCarro e) {
      var erroDTO = ErroResposta.conflito(e.getMessage());
      return ResponseEntity.status(erroDTO.status()).body(erroDTO);
    }
  }

  @GetMapping
  public ResponseEntity<List<PessoaDTO>> pesquisarPessoa(
      @RequestParam(value = "nome", required = false) String nome,
      @RequestParam(value = "cpf", required = false) String cpf) {

    List<Pessoa> resultado = pessoaService.pesquisar(nome, cpf);

    List<PessoaDTO> lista = resultado.stream().map(pessoa -> new PessoaDTO(pessoa.getId(), pessoa.getNome(),
        pessoa.getDataNascimento(), pessoa.getCpf())).collect(Collectors.toList());

    return ResponseEntity.ok(lista);
  }

  @PutMapping("{id}")
  public ResponseEntity<Object> atualizarPessoa(@PathVariable String id, @RequestBody PessoaDTO dto) {
    try {
      UUID idPessoa = UUID.fromString(id);
      Optional<Pessoa> obterPessoa = pessoaService.obterPessoa(idPessoa);
      if (obterPessoa.isEmpty())
        return ResponseEntity.notFound().build();

      Pessoa pessoa = obterPessoa.get();
      pessoa.setNome(dto.nome());
      pessoa.setCpf(dto.cpf());
      pessoa.setDataNascimento(dto.dataNascimento());

      pessoaService.atualizar(pessoa);
      return ResponseEntity.noContent().build();
    } catch (RegistroDuplicado e) {
      var erroDTO = ErroResposta.conflito(e.getMessage());
      return ResponseEntity.status(erroDTO.status()).body(erroDTO);
    }
  }
}
