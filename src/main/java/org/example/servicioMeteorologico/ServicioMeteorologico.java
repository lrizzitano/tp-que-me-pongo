package org.example.servicioMeteorologico;

import java.util.HashMap;

public abstract class ServicioMeteorologico {
  protected final HashMap<String, RespuestaDeClima> cacheClimas;
  protected final HashMap<String, Object> cacheAlertas;
  protected final int llamadosDiarios;

  public ServicioMeteorologico(int llamadosDiarios) {
    this.cacheClimas =  new HashMap<>();
    this.cacheAlertas = new HashMap<>();
    this.llamadosDiarios = llamadosDiarios;
  }

  abstract protected void actualizarClima(String ciudad);

  abstract protected void actualizarAlertas(String ciudad);


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

  public HashMap<String, Object> getAlertasGlobales() {
    return this.cacheAlertas;
  }

  public void actualizarAlertasGlobales() {
    this.cacheAlertas.keySet().forEach(this::actualizarAlertas);
  }

}
