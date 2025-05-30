package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class MotorDeSugerenciasFormales extends MotorDeSugerencias {
  public MotorDeSugerenciasFormales() {}

  @Override
  public List<Atuendo> sugerirAtuendos(List<Prenda> prendas) {
    List<Prenda> prendasFormales = this.filtrarPorFormalidad(prendas, Formalidad.FORMAL);
    return super.sugerirAtuendos(prendasFormales);
  }

  public List<Prenda> filtrarPorFormalidad(List<Prenda> prendas, Formalidad formalidad) {
    return prendas.stream().filter(prenda ->
        prenda.esDeFormalidad(formalidad)).collect(Collectors.toList());
  }
}
