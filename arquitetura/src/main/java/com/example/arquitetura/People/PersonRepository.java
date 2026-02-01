package com.example.arquitetura.People;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
  boolean existsByNome(String nome);
}
