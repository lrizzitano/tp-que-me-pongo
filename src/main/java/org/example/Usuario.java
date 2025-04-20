package org.example;

import java.util.List;

public class Usuario {
  private List<Prenda> prendas;
  private List<Prenda> borradores;
  private List<Atuendo> atuendos;
  private Institucion institucion;

  public Usuario() {
  }

  public Prenda crearBorrador(Tipo tipo) {
    Prenda prenda = new Prenda(tipo);
    borradores.add(prenda);
    return prenda;
  }

  public void guardarPrenda(Prenda prenda) {
    if (prenda.esPrendaValida()) {
      borradores.remove(prenda);
      prendas.add(prenda);
    } else {
      throw new PrendaInvalidaException();
    }
  }

  public Uniforme sugerirUniforme() {
    return institucion.getUniforme();
  }
}
