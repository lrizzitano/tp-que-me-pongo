package org.example;

public class ProveedorDeMotores {
  private static final ProveedorDeMotores instance = new ProveedorDeMotores();

  private MotorDeSugerencias motorDeSugerencias;

  private ProveedorDeMotores() {}

  public static ProveedorDeMotores instance() {
    return instance;
  }

  public void setMotorDeSugerencias(MotorDeSugerencias motorDeSugerencias) {
    this.motorDeSugerencias = motorDeSugerencias;
  }

  public MotorDeSugerencias getMotorDeSugerencias() {
    return motorDeSugerencias;
  }
}
