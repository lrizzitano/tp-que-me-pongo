package org.example;

public class RangoDeTemperaturas {
  private double temperaturaMayor;
  private double temperaturaMenor;

  public RangoDeTemperaturas(double temperaturaMayor, double temperaturaMenor) {
    this.temperaturaMayor = temperaturaMayor;
    this.temperaturaMenor = temperaturaMenor;
  }

  public boolean contiene(double temperatura) {
    return (temperatura < temperaturaMayor
      && temperatura > temperaturaMenor);
  }

  public double getTemperaturaMayor() {
    return temperaturaMayor;
  }

  public double getTemperaturaMenor() {
    return temperaturaMenor;
  }
}
