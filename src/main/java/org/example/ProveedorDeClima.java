package org.example;

public class ProveedorDeClima {
  private static final ProveedorDeClima instance = new ProveedorDeClima();

  private ServicioMeteorologico servicioMeteorologico;

  private ProveedorDeClima() {}

  public static ProveedorDeClima instance() {
    return instance;
  }

  public void setServicioMeteorologico(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }

  public ServicioMeteorologico getServicioMeteorologico() {
    return servicioMeteorologico;
  }
}
