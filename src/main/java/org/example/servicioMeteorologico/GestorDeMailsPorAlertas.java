package org.example.servicioMeteorologico;

import java.util.HashMap;
import java.util.List;

public class GestorDeMailsPorAlertas extends InteresadoEnAlertas {
  private MailSender mailSender;

  public GestorDeMailsPorAlertas(MailSender mailSender) {
    super();
    this.mailSender = mailSender;
  }

  @Override
  public void anteAlerta(HashMap<String, List<String>> alertas) {
    this.suscriptores.forEach((u) -> {
      if (!alertas.get(u.getCiudad()).isEmpty()) {
        mailSender.send(u.getMail(), alertas.get(u.getCiudad()).toString());
      }
    });
  }
}
