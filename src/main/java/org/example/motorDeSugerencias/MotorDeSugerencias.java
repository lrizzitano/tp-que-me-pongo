package org.example.motorDeSugerencias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.example.Atuendo;
import org.example.prenda.Categoria;
import org.example.prenda.Prenda;
import org.example.servicioMeteorologico.ProveedorDeServicioMeteorologico;
import org.example.servicioMeteorologico.ServicioMeteorologico;
import org.example.Usuario;

public class MotorDeSugerencias {

  private ServicioMeteorologico servicioMeteorologico;

  public MotorDeSugerencias() {
    this.servicioMeteorologico = ProveedorDeServicioMeteorologico.instance().getServicioMeteorologico();
  }

  public List<Atuendo> sugerirAtuendos(List<Prenda> prendas, Usuario usuario) {
    List<Prenda> prendasValidas = this.filtrarPorTemperatura(prendas, usuario);

    return this.combinarPrendas(prendasValidas);
  }

  private List<Atuendo> combinarPrendas(List<Prenda> prendas) {
    List<Prenda> prendasSuperiores = this.filtrarPorCategoria(prendas, Categoria.PARTE_SUPERIOR);
    List<Prenda> prendasInferiores = this.filtrarPorCategoria(prendas, Categoria.PARTE_INFERIOR);
    List<Prenda> calzados = this.filtrarPorCategoria(prendas, Categoria.CALZADO);
    List<Atuendo> atuendos = new ArrayList<>();

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

  public List<Prenda> filtrarPorTemperatura(List<Prenda> prendas, Usuario usuario) {
    double temperatura = servicioMeteorologico.getTemperatura(usuario.getCiudad());

    return prendas.stream().filter(prenda ->
            prenda.esParaTemperatura(temperatura)).collect(Collectors.toList());
  }
}
