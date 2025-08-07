package com.depaiva.library.repository;

import com.depaiva.library.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setNome("Mari");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(2004, 1, 16));

        var autorSalvo = repository.save(autor);
        System.out.println("Salvo com sucesso! " + autorSalvo);
    }

    @Test
    public void atualizarTest(){
        var id = UUID.fromString("ee940981-1610-4cce-bd86-8efe987b7825");
        Optional<Autor> possivelAutor = repository.findById(id);
        if(possivelAutor.isPresent()){
            Autor autor = possivelAutor.get();
            System.out.println("Dados do autor: ");
            System.out.println(autor);
            autor.setNome("Carlos");
            repository.save(autor);
        }
    }

    @Test
    public void listarTest(){
        List<Autor> autors = repository.findAll();
        autors.forEach(System.out::println);
    }

    @Test
    public void countAutors(){
        System.out.println("Contagem de autores: " + repository.count());
    }

    @Test
    public void deletarPorIdTest(){
        var id = UUID.fromString("ee940981-1610-4cce-bd86-8efe987b7825");
        repository.deleteById(id);
    }

    @Test
    public void deletarAutorTest(){
        var id = UUID.fromString("f5d46ef6-101c-4de4-9b90-30d1e0a2c363");
        var autor = repository.findById(id).get();
        repository.delete(autor);
    }

}
