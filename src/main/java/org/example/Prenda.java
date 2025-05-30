package org.example;

public class Prenda {
  private TipoDePrenda tipo;
  private Material material;
  private Trama trama;
  private Color colorPrincipal;
  private Color colorSecuandario;

  public Prenda(
      TipoDePrenda tipo, Material material, Trama trama, Color colorPrincipal, Color colorSecuandario
  ) {
    this.tipo = tipo;
    this.material = material;
    this.trama = trama;
    this.colorPrincipal = colorPrincipal;
    this.colorSecuandario = colorSecuandario;
  }

  public Prenda(TipoDePrenda tipo, Material material, Trama trama, Color colorPrincipal) {
    this(tipo, material, trama, colorPrincipal, null);
  }

  public Categoria getCategoria() {
    return this.tipo.getCategoria();
  }
}
