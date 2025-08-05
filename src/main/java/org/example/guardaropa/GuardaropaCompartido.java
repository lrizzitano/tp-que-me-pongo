package org.example.guardaropa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuardaropaCompartido extends Guardaropa {
  private List<PropuestaDeCambio> propuestasDeCambio;

  public GuardaropaCompartido(String nombre) {
    super(nombre);
    propuestasDeCambio = new ArrayList<PropuestaDeCambio>();
  }

  public List<PropuestaDeCambio> getPropuestasPendientes() {
    return propuestasDeCambio.stream().filter(PropuestaDeCambio::estaPendiente).collect(Collectors.toList());
  }

  public void agregarPropuesta(PropuestaDeCambio propuesta) {
    propuestasDeCambio.add(propuesta);
  }
}
