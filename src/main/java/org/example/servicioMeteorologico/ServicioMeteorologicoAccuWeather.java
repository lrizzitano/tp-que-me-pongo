package org.example.servicioMeteorologico;

import java.time.Duration;
import java.util.HashMap;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {

  private AccuWeatherAPI api;
  private final HashMap<String, RespuestaDeClima> ultimasRespuestas = new HashMap();
  private final int llamadosDiarios;

  public ServicioMeteorologicoAccuWeather(AccuWeatherAPI api, int llamadosDiarios) {
    this.api = api;
    this.llamadosDiarios = llamadosDiarios;
  }

  public double getTemperatura(String ciudad) {
    if (!ultimasRespuestas.containsKey(ciudad) || ultimasRespuestas.get(ciudad).expiro()) {
      this.actualizarCiudad(ciudad);
    }
    return ultimasRespuestas.get(ciudad).getTemperatura();
  }

  private void actualizarCiudad(String ciudad) {
    RespuestaDeClima respuesta = new RespuestaDeClima(
        Duration.ofMinutes(1440 / llamadosDiarios),
        api.getWeather(ciudad).get(0)
    );
    ultimasRespuestas.put(ciudad, respuesta);
  }
}
