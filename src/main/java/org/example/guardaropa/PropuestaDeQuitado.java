package org.example.guardaropa;

import org.example.prenda.Prenda;

public class PropuestaDeQuitado extends PropuestaDeCambio {
  public PropuestaDeQuitado(Prenda prenda, GuardaropaCompartido guardaropa) {
    super(prenda, guardaropa);
  }

  @Override
  public void aplicarEnGuardaropa() {
    this.guardaropa.quitarPrenda(this.prenda);
  }

  @Override
  public void revertirEnGuardaropa() {
    this.guardaropa.agregarPrenda(this.prenda);
  }
}
