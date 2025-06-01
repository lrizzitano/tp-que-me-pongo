package org.example;

public class Prenda {
  private TipoDePrenda tipo;
  private Material material;
  private Trama trama;
  private Formalidad formalidad;
  private Color colorPrincipal;
  private Color colorSecuandario;

  public Prenda(
      TipoDePrenda tipo, Material material, Trama trama, Formalidad formalidad, Color colorPrincipal, Color colorSecuandario
  ) {
    this.tipo = tipo;
    this.material = material;
    this.trama = trama;
    this.colorPrincipal = colorPrincipal;
    this.colorSecuandario = colorSecuandario;
  }

  public Prenda(TipoDePrenda tipo, Material material, Trama trama, Formalidad formalidad, Color colorPrincipal) {
    this(tipo, material, trama, formalidad, colorPrincipal, null);
  }

  public Categoria getCategoria() {
    return this.tipo.getCategoria();
  }

  public boolean esDeCategoria(Categoria categoria) {
    return this.getCategoria() == categoria;
  }

  public boolean esDeFormalidad(Formalidad formalidad) {
    return this.formalidad == formalidad;
  }

  public boolean esParaTemperatura(double temperatura) {
    return this.tipo.esParaTemperatura(temperatura);
  }
}
