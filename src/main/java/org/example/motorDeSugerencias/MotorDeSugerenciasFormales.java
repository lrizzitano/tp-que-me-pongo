package org.example.motorDeSugerencias;

import java.util.List;
import java.util.stream.Collectors;
import org.example.prenda.Formalidad;
import org.example.prenda.Prenda;
import org.example.usuario.Usuario;

public class MotorDeSugerenciasFormales extends MotorDeSugerencias {

  public MotorDeSugerenciasFormales() {
    super();
  }

  @Override
  public List<Prenda> prendasValidas(Usuario usuario) {
    List<Prenda> prendasValidas = super.prendasValidas(usuario);

    if (usuario.esAdultoMayor()) {
      prendasValidas = this.filtrarPorFormalidad(prendasValidas, Formalidad.FORMAL);
    }

    return prendasValidas;
  }

  private List<Prenda> filtrarPorFormalidad(List<Prenda> prendas, Formalidad formalidad) {
    return prendas.stream().filter(prenda ->
        prenda.esDeFormalidad(formalidad)).collect(Collectors.toList());
  }
}
