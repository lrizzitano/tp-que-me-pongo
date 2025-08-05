package org.example.servicioMeteorologico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class ServicioMeteorologico {
  protected final HashMap<String, RespuestaDeClima> cacheClimas;
  protected final HashMap<String, List<String>> cacheAlertas;
  protected final int llamadosDiarios;
  protected List<InteresadoEnAlertas> interesadoEnAlertas;

  public ServicioMeteorologico(int llamadosDiarios) {
    this.cacheClimas = new HashMap<>();
    this.cacheAlertas = new HashMap<>();
    this.llamadosDiarios = llamadosDiarios;
    this.interesadoEnAlertas = new ArrayList<>();
  }

  abstract protected void actualizarClima(String ciudad);

  abstract protected void actualizarAlertas(String ciudad);

  public void agregarInteresado(InteresadoEnAlertas interesadoEnAlertas) {
    this.interesadoEnAlertas.add(interesadoEnAlertas);
  }

  public void quitarInteresado(InteresadoEnAlertas interesadoEnAlertas) {
    this.interesadoEnAlertas.remove(interesadoEnAlertas);
  }

  public double getTemperatura(String ciudad) {
    if (!cacheClimas.containsKey(ciudad) || cacheClimas.get(ciudad).expiro()) {
      this.actualizarClima(ciudad);
    }
    return cacheClimas.get(ciudad).getTemperatura();
  }

  public Object getAlertas(String ciudad) {
    if (!cacheAlertas.containsKey(ciudad)) {
      this.actualizarAlertas(ciudad);
    }
    return cacheAlertas.get(ciudad);
  }

  public HashMap<String, List<String>> getAlertasGlobales() {
    return this.cacheAlertas;
  }

  public void actualizarAlertasGlobales() {
    this.cacheAlertas.keySet().forEach(this::actualizarAlertas);
    this.interesadoEnAlertas.forEach((interesadoEnAlertas) -> {
      interesadoEnAlertas.anteAlerta(cacheAlertas);
    });
  }

}
