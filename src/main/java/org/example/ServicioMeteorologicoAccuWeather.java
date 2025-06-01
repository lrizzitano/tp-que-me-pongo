package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {

  private AccuWeatherAPI api;

  public ServicioMeteorologicoAccuWeather(AccuWeatherAPI api) {
    this.api = api;
  }

  public double getTemperatura(String ciudad) {
    Map<String, Object> temperatura = (Map<String, Object>) this.getClima(ciudad).get("Temperature");
    return this.normalizarGradosCelcius(temperatura);
  }

  public Map<String, Object> getClima(String ciudad) {
    return api.getWeather(ciudad).get(0);
  }

  public double normalizarGradosCelcius(Map<String, Object> temperatura) {
    double valor = (double) temperatura.get("Value");
    if (temperatura.get("Unit") == "f") {
      return (valor - 32) * 1.8;
    } else {
      return valor;
    }
  }
}
