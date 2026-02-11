package io.github.Depaiiva.carApi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.Depaiiva.carApi.service.CarroService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carro")
@RequiredArgsConstructor
public class CarroController {

  private final CarroService carroService;
}
