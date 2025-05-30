package org.example;

public class TipoDePrenda {
  private String descripcion;
  private Categoria categoria;

  public TipoDePrenda(String descripcion, Categoria categoria) {
    this.descripcion = descripcion;
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }
}
