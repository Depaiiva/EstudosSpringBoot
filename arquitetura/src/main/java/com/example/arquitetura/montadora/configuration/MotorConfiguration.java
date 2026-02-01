package com.example.arquitetura.montadora.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.arquitetura.montadora.Motor;
import com.example.arquitetura.montadora.TipoMotor;

@Configuration
public class MotorConfiguration {

  @Bean
  public Motor motorCivicao() {
    Motor motor = new Motor(TipoMotor.HIBRIDO);
    return motor;
  }

  @Bean
  public Motor motorBYD() {
    Motor motor = new Motor(TipoMotor.ELETRICO);
    return motor;
  }

  @Bean
  public Motor motorGranSiena() {
    Motor motor = new Motor(TipoMotor.COMBUSTAO);
    return motor;
  }
}
