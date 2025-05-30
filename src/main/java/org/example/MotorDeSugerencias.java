package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MotorDeSugerencias {

  public List<Atuendo> sugerirAtuendos(List<Prenda> prendas) {
    List<Prenda> prendasSuperiores = this.filtrarPorCategoria(prendas, Categoria.PARTE_SUPERIOR);
    List<Prenda> prendasInferiores = this.filtrarPorCategoria(prendas, Categoria.PARTE_INFERIOR);
    List<Prenda> calzados = this.filtrarPorCategoria(prendas, Categoria.CALZADO);
    List<Atuendo> atuendos = new ArrayList<Atuendo>();

    for (Prenda prendaSuperior : prendasSuperiores) {
      for (Prenda prendaInferior : prendasInferiores) {
        for (Prenda calzado : calzados) {
          atuendos.add(new Atuendo(Arrays.asList(prendaSuperior, prendaInferior, calzado)));
        }
      }
    }

    return atuendos;
  }

  public List<Prenda> filtrarPorCategoria(List<Prenda> prendas, Categoria categoria) {
    return prendas.stream().filter(prenda ->
        prenda.esDeCategoria(categoria)).collect(Collectors.toList());
  }
}
