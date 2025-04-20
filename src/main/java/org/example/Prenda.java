package org.example;

import static java.util.Objects.requireNonNull;

public class Prenda {
  private Tipo tipo;
  private String material;
  private Trama trama;
  private Color colorPrincipal;
  private Color colorSecuandario;

  public Prenda(Tipo tipo) {
    this.tipo = requireNonNull(tipo);
    this.trama = Trama.LISA;
    this.colorSecuandario = null;
  }

  public void setMaterial(String material) {
    this.material = requireNonNull(material);
  }

  public void setTrama(Trama trama) {
    this.trama = requireNonNull(trama);
  }

  public void setColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = requireNonNull(colorPrincipal);
  }

  public void setColorSecuandario(Color colorSecuandario) {
    this.colorSecuandario = colorSecuandario;
  }

  public boolean esPrendaValida() {
    return this.material != null && this.trama != null && this.colorPrincipal != null;
  }

  public Categoria categoria() {
    return this.tipo.getCategoria();
  }
}
