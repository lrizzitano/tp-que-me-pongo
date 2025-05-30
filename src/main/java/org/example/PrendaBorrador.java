package org.example;

import static java.util.Objects.requireNonNull;

public class PrendaBorrador {
  private TipoDePrenda tipo;
  private Material material;
  private Trama trama;
  private Color colorPrincipal;
  private Color colorSecuandario;

  public PrendaBorrador(TipoDePrenda tipo) {
    this.tipo = requireNonNull(tipo);
    this.trama = Trama.LISA;
  }

  public void setTipo(TipoDePrenda tipo) {
    this.tipo = requireNonNull(tipo);
  }

  public void setMaterial(Material material) {
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

  public Prenda construirPrenda() {
    requireNonNull(material);
    requireNonNull(colorPrincipal);
    return new Prenda(tipo, material, trama, colorPrincipal, colorSecuandario);
  }
}
