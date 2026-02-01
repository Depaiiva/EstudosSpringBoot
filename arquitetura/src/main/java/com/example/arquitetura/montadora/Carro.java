package com.example.arquitetura.montadora;

public class Carro {
  private Motor motor;
  private String color;
  private Modelo modelo;
  private Marca marca;
  private Integer gasolina;

  public Carro(Motor motor) {
    this.motor = motor;
  }

  public Motor getMotor() {
    return motor;
  }

  public void setMotor(Motor motor) {
    this.motor = motor;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Modelo getModelo() {
    return modelo;
  }

  public void setModelo(Modelo modelo) {
    this.modelo = modelo;
  }

  public Marca getMarca() {
    return marca;
  }

  public void setMarca(Marca marca) {
    this.marca = marca;
  }

  public Integer getGasolina() {
    return gasolina;
  }

  public void setGasolina(Integer gasolina) {
    this.gasolina = gasolina;
  }

}
