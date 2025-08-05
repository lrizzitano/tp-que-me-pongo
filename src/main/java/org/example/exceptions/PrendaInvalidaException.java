package org.example.exceptions;

public class PrendaInvalidaException extends RuntimeException {
  public PrendaInvalidaException() {
    super("Se debe definir el tipo, material, trama y color de la prenda antes de guardarla");
  }
}
