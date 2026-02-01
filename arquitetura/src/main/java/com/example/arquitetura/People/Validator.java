package com.example.arquitetura.People;

import org.springframework.stereotype.Component;

@Component
public class Validator {

  private PersonRepository repository;

  public Validator(PersonRepository repository) {
    this.repository = repository;
  }

  public void validarNome(PersonEntity person) {
    if (repository.existsByNome(person.getNome())) {
      throw new IllegalArgumentException("ERRO. Nome existente no banco de dados");
    }
  }
}
