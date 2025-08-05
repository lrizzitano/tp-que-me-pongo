package org.example.servicioMeteorologico;

import java.util.HashMap;
import java.util.List;

public class GestorDeNotificacionesPorAlertas extends InteresadoEnAlertas {
  private NotificationService notificationService;

  public GestorDeNotificacionesPorAlertas(NotificationService notificationService) {
    super();
    this.notificationService = notificationService;
  }

  @Override
  public void anteAlerta(HashMap<String, List<String>> alertas) {
    this.suscriptores.forEach((u) -> {
      if (alertas.get(u.getCiudad()).contains("STORM")) {
        notificationService.notify("Favor de llevar paraguas");
      }
      if (alertas.get(u.getCiudad()).contains("HAIL")) {
        notificationService.notify("No saques el auto que lo haces colador");
      }
    });
  }
}
