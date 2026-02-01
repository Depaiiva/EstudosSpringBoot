package io.github.Depaiiva.carApi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pessoa", schema = "public")
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Pessoa {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "nome", length = 50, nullable = false)
  private String nome;

  @Column(name = "cpf", nullable = false)
  private String cpf;

  @Column(name = "data_nascimento", nullable = false)
  private LocalDate dataNascimento;

  @CreatedDate
  @Column(name = "data_cadastro")
  private LocalDateTime dataCadastro;

  @LastModifiedDate
  @Column(name = "data_atualizacao")
  private LocalDateTime dataAtualizacao;

  @Column(name = "id_usuario")
  private UUID idUsuario;

  // @OneToMany(mappedBy = "dono")
  @Transient
  private List<Carro> carros;
}
