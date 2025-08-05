package org.example.servicioMeteorologico;

public interface MailSender {
  void send(String direccion, String mensaje);
}
