package org.example.guardaropa;

import java.util.ArrayList;
import java.util.List;
import org.example.exceptions.PrendaInexistenteException;
import org.example.prenda.Prenda;

public class Guardaropa {
  private String nombre;
  private List<Prenda> prendas;

  public Guardaropa(String nombre) {
    this.nombre = nombre;
    this.prendas = new ArrayList<Prenda>();
  }

  public void agregarPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda) {
    if (!this.prendas.contains(prenda)) {
      throw new PrendaInexistenteException();
    }

    this.prendas.remove(prenda);
  }
}
