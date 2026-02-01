package com.example.arquitetura.montadora;

public class Civicao extends Carro {

  private String nomeCarro;

  public Civicao(Motor motor) {
    super(motor);
    setGasolina(50);
    if (motor.getTipoMotor() == TipoMotor.COMBUSTAO) {
      setColor("Bege");
      setModelo(Modelo.POPULAR);
      setMarca(Marca.FIAT);
      this.nomeCarro = "GranSiena";
    } else if (motor.getTipoMotor() == TipoMotor.HIBRIDO) {
      setColor("Black");
      setModelo(Modelo.SEDAN);
      setMarca(Marca.HONDA);
      this.nomeCarro = "Civicao";
    } else {
      setColor("Black");
      setModelo(Modelo.ELETRICO);
      setMarca(Marca.BYD);
      this.nomeCarro = "King";
    }
  }

  public String getNomeCarro() {
    return nomeCarro;
  }

  public String dirigirCarro() {
    Integer gasolina = getGasolina() - 20;
    setGasolina(gasolina);
    return "Dirigindo... " + this.nomeCarro;
  }

  public boolean possoDirigir() {
    return getGasolina() < 20 ? false : true;
  }

  public void abastecer(Integer gasolina) {
    System.out.println("Abastecendo o " + this.nomeCarro);
    setGasolina(gasolina);
  }

  @Override
  public String toString() {
    return "[getMotor()=" + getMotor() + ", getColor()=" + getColor() + ", getModelo()=" + getModelo()
        + ", getMarca()=" + getMarca() + ", getGasolina()=" + getGasolina() + "]";
  }

}
