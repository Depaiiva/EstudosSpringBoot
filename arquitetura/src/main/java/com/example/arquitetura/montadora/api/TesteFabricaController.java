package com.example.arquitetura.montadora.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.arquitetura.montadora.Civicao;
import com.example.arquitetura.montadora.Motor;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

  @Autowired
  @Qualifier("motorCivicao")
  private Motor motor;

  @GetMapping
  public String usarCarro() {
    Civicao civicao = new Civicao(motor);
    return civicao.possoDirigir() ? civicao.dirigirCarro() + " " + civicao.toString()
        : "não posso usar o carro, precisa abastecer";
  }
}
