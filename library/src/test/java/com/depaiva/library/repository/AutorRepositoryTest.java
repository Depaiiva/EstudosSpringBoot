package com.depaiva.library.repository;

import com.depaiva.library.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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

}
