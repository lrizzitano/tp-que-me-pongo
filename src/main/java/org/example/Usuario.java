package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private int edad;
  private List<Prenda> prendas = new ArrayList<>();

  public Usuario(int edad) {
    this.edad = edad;
  }

  public void guardarBorrador(PrendaBorrador borrador) {
    prendas.add(borrador.construirPrenda());
  }

  public List<Atuendo> sugerirAtuendos() {
    return ProveedorDeMotores.instance().getMotorDeSugerencias().sugerirAtuendos(prendas, this);
  }

  public boolean esAdultoMayor() {
    return this.edad > 55;
  }
}
