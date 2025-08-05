package org.example.guardaropa;

import org.example.prenda.Prenda;

public abstract class PropuestaDeCambio {

  protected Prenda prenda;
  protected GuardaropaCompartido guardaropa;
  protected EstadoPropuesta estado;

  public PropuestaDeCambio(Prenda prenda, GuardaropaCompartido guardaropa) {
    this.prenda = prenda;
    this.guardaropa = guardaropa;
    this.estado = EstadoPropuesta.PENDIENTE;
  }

  public Boolean estaPendiente(){
    return estado == EstadoPropuesta.PENDIENTE;
  }

  public void aceptar() {
    if (estado != EstadoPropuesta.PENDIENTE) {
      throw new IllegalStateException("Solo se pueden aceptar propuestas pendientes");
    }
    this.aplicarEnGuardaropa();
    this.estado = EstadoPropuesta.ACEPTADA;
  }

  public void deshacer() {
    if (estado != EstadoPropuesta.PENDIENTE) {
      throw new IllegalStateException("Solo se pueden deshacer propuestas aceptadas");
    }
    this.revertirEnGuardaropa();
    this.estado = EstadoPropuesta.PENDIENTE;
  }

  public void rechazar() {
    if (estado != EstadoPropuesta.PENDIENTE) {
      throw new IllegalStateException("Solo se pueden rechazar propuestas pendientes");
    }
    this.estado = EstadoPropuesta.RECHAZADA;
  }

  abstract public void aplicarEnGuardaropa();
  abstract public void revertirEnGuardaropa();

}
