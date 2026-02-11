package io.github.Depaiiva.carApi.controller.dto;

import java.time.LocalDate;
import java.util.UUID;

import io.github.Depaiiva.carApi.model.Marca;
import io.github.Depaiiva.carApi.model.Modelo;

public record CadastroCarroDTO(
    UUID id,
    String nome,
    LocalDate ano,
    String tipo,
    Marca marca,
    Modelo modelo,
    UUID idPessoa) {
}
