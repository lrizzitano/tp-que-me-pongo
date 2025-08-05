package org.example.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.example.guardaropa.Guardaropa;
import org.example.motorDeSugerencias.Atuendo;
import org.example.motorDeSugerencias.MotorDeSugerencias;
import org.example.motorDeSugerencias.ProveedorDeMotores;
import org.example.prenda.Prenda;
import org.example.prenda.PrendaBorrador;

public class Usuario {
  private int edad;
  private String mail;
  private String ciudad;
  private List<PrendaBorrador> borradores;
  private List<Guardaropa> guardaropas;
  private MotorDeSugerencias motorDeSugerencias;
  private Atuendo sugerenciaDiaria;

  public Usuario(int edad, String mail, String ciudad) {
    this.edad = edad;
    this.mail = mail;
    this.ciudad = ciudad;
    this.borradores = new ArrayList<>();
    this.guardaropas = new ArrayList<>();
    this.motorDeSugerencias = ProveedorDeMotores.instance().getMotorDeSugerencias();
    this.actualizarSugerenciaDiaria();
  }

  public String getCiudad() {
    return this.ciudad;
  }

  public String getMail() {
    return this.mail;
  }

  public void agregarBorrador(PrendaBorrador borrador) {
    this.borradores.add(borrador);
  }

  public void guardarBorrador(PrendaBorrador borrador, Guardaropa guardaropa) {
    guardaropa.agregarPrenda(borrador.construirPrenda());
  }

  public List<Prenda> getPrendasDisponibles() {
    return this.guardaropas
        .stream()
        .map(Guardaropa::getPrendas)
        .flatMap(List::stream)
        .collect(Collectors.toList());
  }

  public List<Atuendo> sugerirAtuendos() {
    return motorDeSugerencias.sugerirAtuendos(this);
  }

  public void actualizarSugerenciaDiaria() {
    this.sugerenciaDiaria = this.motorDeSugerencias.getSugerenciaDiaria(this);
  }

  public boolean esAdultoMayor() {
    return this.edad > 55;
  }
}
