package org.example.servicioMeteorologico;

public class ProveedorDeServicioMeteorologico {
  private static final ProveedorDeServicioMeteorologico instance = new ProveedorDeServicioMeteorologico();

  private ServicioMeteorologico servicioMeteorologico;

  private ProveedorDeServicioMeteorologico() {}

  public static ProveedorDeServicioMeteorologico instance() {
    return instance;
  }

  public void setServicioMeteorologico(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }

  public ServicioMeteorologico getServicioMeteorologico() {
    return servicioMeteorologico;
  }
}
