package org.example.exceptions;

public class PrendaInexistenteException extends RuntimeException {
  public PrendaInexistenteException() {
    super("La prenda especificada no existe");
  }
}
