package org.example.prenda;

public class TipoDePrenda {
  private String descripcion;
  private Categoria categoria;
  private RangoDeTemperaturas temperaturasDeUso;

  public TipoDePrenda(
      String descripcion,
      Categoria categoria,
      RangoDeTemperaturas temperaturasDeUso,
      boolean esAptoLluvia) {
    this.descripcion = descripcion;
    this.categoria = categoria;
    this.temperaturasDeUso = temperaturasDeUso;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }

  public boolean esParaTemperatura(double temperatura) {
    return this.temperaturasDeUso.contiene(temperatura);
  }
}
