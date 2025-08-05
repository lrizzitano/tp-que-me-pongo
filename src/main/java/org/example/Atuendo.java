package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.exceptions.AtuendoConPocasPrendasException;
import org.example.prenda.Prenda;

public class Atuendo {
  private List<Prenda> prendas = new ArrayList<>();

  public Atuendo(List<Prenda> prendas) {
    if (prendas.size() <= 2) {
      throw new AtuendoConPocasPrendasException();
    }
    this.prendas = prendas;
  }
}
