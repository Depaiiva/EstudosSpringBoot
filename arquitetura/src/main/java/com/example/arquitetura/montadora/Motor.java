package com.example.arquitetura.montadora;

public class Motor {
  private TipoMotor tipoMotor;
  private Integer cilindros;
  private String id;

  public Motor(TipoMotor tipoMotor) {
    this.tipoMotor = tipoMotor;
  }

  public TipoMotor getTipoMotor() {
    return tipoMotor;
  }

  public void setTipoMotor(TipoMotor tipoMotor) {
    this.tipoMotor = tipoMotor;
  }

  public Integer getCilindros() {
    return cilindros;
  }

  public void setCilindros(Integer cilindros) {
    this.cilindros = cilindros;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return " " + tipoMotor;
  }

}
