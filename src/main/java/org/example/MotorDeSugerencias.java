package org.example;

import java.util.List;

public interface MotorDeSugerencias {
  List<Atuendo> sugerirAtuendos(List<Prenda> prendas, Usuario usuario);
}
