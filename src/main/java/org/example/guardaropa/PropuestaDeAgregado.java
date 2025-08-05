package org.example.guardaropa;

import org.example.prenda.Prenda;

public class PropuestaDeAgregado extends PropuestaDeCambio {
  public PropuestaDeAgregado(Prenda prenda, GuardaropaCompartido guardaropa) {
    super(prenda, guardaropa);
  }

  @Override
  public void aceptar() {
    this.guardaropa.aceptarPropuesta(this);
    this.guardaropa.agregarPrenda(this.prenda);
  }

  @Override
  public void deshacer() {
    this.guardaropa.deshacerPropuesta(this);
    this.guardaropa.quitarPrenda(this.prenda);
  }
}
