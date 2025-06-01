package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class MotorDeSugerenciasFormales extends MotorDeSugerencias {

  public MotorDeSugerenciasFormales() {
    super();
  }

  @Override
  public List<Atuendo> sugerirAtuendos(List<Prenda> prendas, Usuario usuario) {
    List<Prenda> prendasValidas = prendas;

    if (usuario.esAdultoMayor()) {
      prendasValidas = this.filtrarPorFormalidad(prendas, Formalidad.FORMAL);
    }

    return super.sugerirAtuendos(prendasValidas, usuario);
  }

  public List<Prenda> filtrarPorFormalidad(List<Prenda> prendas, Formalidad formalidad) {
    return prendas.stream().filter(prenda ->
        prenda.esDeFormalidad(formalidad)).collect(Collectors.toList());
  }
}
