package com.example.arquitetura.People;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonController {

  private PersonService service;

  public PersonController(PersonService service) {
    this.service = service;
  }

  @PostMapping
  public PersonEntity salvar(@RequestBody PersonEntity person) {
    return service.salvaPerson(person);
  }

  @PutMapping("{id}")
  public void atualizar(@PathVariable("id") Integer id, @RequestBody PersonEntity person) {
    person.setId(id);
    service.update(person);
  }

  @GetMapping("{id}")
  public PersonEntity busca(@PathVariable("id") Integer id) {
    return service.buscar(id);
  }
}
