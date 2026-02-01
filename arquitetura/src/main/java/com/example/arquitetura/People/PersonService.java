package com.example.arquitetura.People;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
  private PersonRepository repository;
  private Validator validator;

  public PersonService(PersonRepository repository,
      Validator validator) {
    this.repository = repository;
    this.validator = validator;
  }

  public PersonEntity salvaPerson(PersonEntity person) {
    validator.validarNome(person);
    return repository.save(person);
  }

  public void update(PersonEntity person) {
    repository.save(person);
  }

  public PersonEntity buscar(Integer id) {
    return repository.findById(id).orElse(null);
  }
}
