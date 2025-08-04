package org.example.ServicioMeteorologico;

import java.time.Period;
import java.util.Map;

public class RespuestaDeClima {
  private Period periodoValidez;
  private Map<String, Object> respuesta;

  public RespuestaDeClima(Period periodoValidez,  Map<String, Object> respuesta) {
    this.periodoValidez = periodoValidez;
    this.respuesta = respuesta;
  }

  public getTemperatura() {

  }
}
