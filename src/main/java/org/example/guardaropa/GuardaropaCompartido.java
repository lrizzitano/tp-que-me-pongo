package org.example.guardaropa;

import java.util.ArrayList;
import java.util.List;
import org.example.exceptions.OperacionDePropuestaInvalidaException;

public class GuardaropaCompartido extends Guardaropa {
  private List<PropuestaDeCambio> propuestasPendientes;
  private List<PropuestaDeCambio> propuestasAceptadas;

  public GuardaropaCompartido(String nombre) {
    super(nombre);
    propuestasPendientes = new ArrayList<PropuestaDeCambio>();
    propuestasAceptadas = new ArrayList<PropuestaDeCambio>();
  }

  public List<PropuestaDeCambio> getPropuestasPendientes() {
    return propuestasPendientes;
  }

  public void agregarPropuesta(PropuestaDeCambio propuesta) {
    propuestasPendientes.add(propuesta);
  }

  public void aceptarPropuesta(PropuestaDeCambio propuesta) {
    if (!propuestasPendientes.contains(propuesta)) {
      throw new OperacionDePropuestaInvalidaException(
          "La propuesta especificada no existe o ya fue aceptada"
      );
    }
    propuestasPendientes.remove(propuesta);
    propuestasAceptadas.add(propuesta);
  }

  public void rechazarPropuesta(PropuestaDeCambio propuesta) {
    if (!propuestasPendientes.contains(propuesta)) {
      throw new OperacionDePropuestaInvalidaException(
          "La propuesta especificada no existe o ya fue aceptada"
      );
    }
    propuestasPendientes.remove(propuesta);
  }

  public void deshacerPropuesta(PropuestaDeCambio propuesta) {
    if (!propuestasAceptadas.contains(propuesta)) {
      throw new OperacionDePropuestaInvalidaException(
          "La propuesta especificada no existe o no fue aceptada"
      );
    }
    propuestasAceptadas.remove(propuesta);
    propuestasPendientes.add(propuesta);
  }
}
