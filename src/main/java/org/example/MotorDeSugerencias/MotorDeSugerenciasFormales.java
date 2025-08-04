package org.example.MotorDeSugerencias;

import java.util.List;
import java.util.stream.Collectors;
import org.example.Atuendo;
import org.example.Prenda.Formalidad;
import org.example.Prenda.Prenda;
import org.example.Usuario;

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
