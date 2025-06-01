package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private int edad;
  private String ciudad;
  private List<Prenda> prendas;
  private MotorDeSugerencias motorDeSugerencias;

  public Usuario(int edad, String ciudad) {
    this.edad = edad;
    this.ciudad = ciudad;
    this.prendas = new ArrayList<>();
    this.motorDeSugerencias = ProveedorDeMotores.instance().getMotorDeSugerencias();
  }

  public String getCiudad() {
    return this.ciudad;
  }

  public void guardarBorrador(PrendaBorrador borrador) {
    prendas.add(borrador.construirPrenda());
  }

  public List<Atuendo> sugerirAtuendos() {
    return motorDeSugerencias.sugerirAtuendos(prendas, this);
  }

  public boolean esAdultoMayor() {
    return this.edad > 55;
  }
}
