package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.MotorDeSugerencias.MotorDeSugerencias;
import org.example.MotorDeSugerencias.ProveedorDeMotores;
import org.example.Prenda.Prenda;
import org.example.Prenda.PrendaBorrador;

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
