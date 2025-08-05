package org.example.guardaropa;

import org.example.prenda.Prenda;

public abstract class PropuestaDeCambio {

  protected Prenda prenda;
  protected GuardaropaCompartido guardaropa;

  public PropuestaDeCambio(Prenda prenda,  GuardaropaCompartido guardaropa) {
    this.prenda = prenda;
    this.guardaropa = guardaropa;
  }

  abstract public void aceptar();

  abstract public void deshacer();

  public void rechazar() {
    this.guardaropa.rechazarPropuesta(this);
  }
}
