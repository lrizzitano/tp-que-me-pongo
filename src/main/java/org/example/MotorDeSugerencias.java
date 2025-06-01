package org.example;

import java.util.List;
import java.util.stream.Collectors;

public abstract class MotorDeSugerencias {

  private ServicioMeteorologico servicioMeteorologico;

  public MotorDeSugerencias() {
    this.servicioMeteorologico = ProveedorDeClima.instance().getServicioMeteorologico();
  }

  abstract List<Atuendo> sugerirAtuendos(List<Prenda> prendas, Usuario usuario);

  public List<Prenda> filtrarPorTemperatura(List<Prenda> prendas, Usuario usuario) {
    double temperatura = servicioMeteorologico.getTemperatura(usuario.getCiudad());

    return prendas.stream().filter(prenda ->
            prenda.esParaTemperatura(temperatura)).collect(Collectors.toList());
  }
}
