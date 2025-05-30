package org.example;

import java.util.List;

public class Usuario {
  private List<Prenda> prendas;
  private List<Atuendo> atuendos;

  public Usuario() {}

  public void guardarBorrador(PrendaBorrador borrador) {
    prendas.add(borrador.construirPrenda());
  }
}
