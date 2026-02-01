package io.github.Depaiiva.carApi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.Depaiiva.carApi.model.Carro;
import io.github.Depaiiva.carApi.model.Pessoa;

public interface CarroRepository extends JpaRepository<Carro, UUID> {

  boolean existsByDono(Pessoa dono);
}
