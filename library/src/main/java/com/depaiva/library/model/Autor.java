package com.depaiva.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "autor", schema = "public")
@Getter
@Setter
@ToString
public class Autor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "data_nascimento",  nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;

    //@OneToMany(mappedBy = "autor")
    @Transient
    private List<Livro> livros;


    // @Column - definições:
    // nullable é a mesma coisa que o not null no SQL
    // length é o tanto de caracteres varchar no SQL. OBS: só funciona com atributos do tipo String
    // name é o nome de acordo com as colunas na tabela. Se o nome for o mesmo da coluna respectiva da tabela não precisa especificar aqui

}
