package org.example.servicioMeteorologico;

import java.time.Duration;

public class ServicioMeteorologicoAccuWeather extends ServicioMeteorologico {

  private AccuWeatherAPI api;

  public ServicioMeteorologicoAccuWeather(AccuWeatherAPI api, int llamadosDiarios) {
    super(llamadosDiarios);
    this.api = api;
  }

  @Override
  protected void actualizarClima(String ciudad) {
    RespuestaDeClima respuesta = new RespuestaDeClima(
        Duration.ofMinutes(1440 / llamadosDiarios),
        api.getWeather(ciudad).get(0)
    );
    cacheClimas.put(ciudad, respuesta);
  }

  @Override
  protected void actualizarAlertas(String ciudad) {
    cacheAlertas.put(ciudad, api.getAlerts(ciudad).get(0).get("CurrentAlerts"));
  }
}
