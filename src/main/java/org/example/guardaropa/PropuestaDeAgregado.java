package org.example.guardaropa;

import org.example.prenda.Prenda;

public class PropuestaDeAgregado extends PropuestaDeCambio {
  public PropuestaDeAgregado(Prenda prenda, GuardaropaCompartido guardaropa) {
    super(prenda, guardaropa);
  }

  @Override
  public void aplicarEnGuardaropa() {
    this.guardaropa.agregarPrenda(this.prenda);
  }

  @Override
  public void revertirEnGuardaropa() {
    this.guardaropa.quitarPrenda(this.prenda);
  }
}
