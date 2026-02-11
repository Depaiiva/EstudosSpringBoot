package io.github.Depaiiva.carApi.service;

import org.springframework.stereotype.Service;

import io.github.Depaiiva.carApi.repository.CarroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarroService {

  private final CarroRepository carroRepository;
}
