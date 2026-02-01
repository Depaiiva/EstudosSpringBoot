package io.github.Depaiiva.carApi.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "carro")
@Data
public class Carro {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column
  private String nome;

  @Enumerated(EnumType.STRING)
  @Column(name = "marca", nullable = false)
  private Marca marca;

  @Enumerated(EnumType.STRING)
  @Column(name = "modelo", nullable = false)
  private Modelo modelo;

  @Column(name = "ano", nullable = false)
  private LocalDate ano;

  @Column(name = "tipo", nullable = false)
  private String tipo;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_dono")
  private Pessoa dono;
}
