package org.example;

public class ProveedorDeMotores {
  private static final ProveedorDeMotores instance = new ProveedorDeMotores();

  private MotorDeSugerenciasEstandar motorDeSugerencias;

  private ProveedorDeMotores() {}

  public static ProveedorDeMotores instance() {
    return instance;
  }

  public void setMotorDeSugerencias(MotorDeSugerenciasEstandar motorDeSugerencias) {
    this.motorDeSugerencias = motorDeSugerencias;
  }

  public MotorDeSugerenciasEstandar getMotorDeSugerencias() {
    return motorDeSugerencias;
  }
}
