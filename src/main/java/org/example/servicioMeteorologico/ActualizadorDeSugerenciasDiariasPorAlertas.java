package org.example.servicioMeteorologico;

import java.util.HashMap;
import java.util.List;

public class ActualizadorDeSugerenciasDiariasPorAlertas extends InteresadoEnAlertas {

  public ActualizadorDeSugerenciasDiariasPorAlertas() {
    super();
  }

  @Override
  public void anteAlerta(HashMap<String, List<String>> alertas) {
    this.suscriptores.forEach((u) -> {
      if (!alertas.get(u.getCiudad()).isEmpty()) {
        u.actualizarSugerenciaDiaria();
      }
    });
  }
}
