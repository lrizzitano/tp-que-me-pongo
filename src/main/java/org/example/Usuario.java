package org.example;

import java.util.List;

public class Usuario {
  private int edad;
  private List<Prenda> prendas;
  private List<Atuendo> atuendos;
  private MotorDeSugerencias motor;

  public Usuario(int edad) {
    this.edad = edad;
  }

  public void setMotorDeSugerencias(MotorDeSugerencias motor) {
    this.motor = motor;
  }

  public void guardarBorrador(PrendaBorrador borrador) {
    prendas.add(borrador.construirPrenda());
  }
}
