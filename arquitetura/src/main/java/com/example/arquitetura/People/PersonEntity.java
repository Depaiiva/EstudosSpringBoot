package com.example.arquitetura.People;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_person")
public class PersonEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "idade")
  private Integer idade;

  @Column(name = "sexo")
  private String sexo;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  @Override
  public String toString() {
    return "PersonEntity [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + "]";
  }

}
