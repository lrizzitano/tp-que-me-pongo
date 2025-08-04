package org.example.ServicioMeteorologico;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

public class RespuestaDeClima {
  private final LocalDateTime limiteExpiracion;
  private final Map<String, Object> respuesta;

  public RespuestaDeClima(Duration tiempoValidez, Map<String, Object> respuesta) {
    this.limiteExpiracion = LocalDateTime.now().plus(tiempoValidez);
    this.respuesta = respuesta;
  }

  public double getTemperatura() {
    Map<String, Object> temperatura = (Map<String, Object>) respuesta.get("Temperature");
    return this.normalizarGradosCelcius(temperatura);
  }

  public Boolean expiro() {
    return LocalDateTime.now().isAfter(this.limiteExpiracion);
  }

  private double normalizarGradosCelcius(Map<String, Object> temperatura) {
    double valor = (double) temperatura.get("Value");
    if ("f".equalsIgnoreCase((String) temperatura.get("Type"))) {
      return (valor - 32) * 1.8;
    } else {
      return valor;
    }
  }
}
