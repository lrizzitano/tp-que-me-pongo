package org.example.usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuariosRepo {
  private static final UsuariosRepo instance = new UsuariosRepo();
  private List<Usuario> suscriptores;

  private UsuariosRepo() {
    this.suscriptores = new ArrayList<>();
  }

  public static UsuariosRepo instance() {
    return instance;
  }

  public void suscribir(Usuario usuario) {
    this.suscriptores.add(usuario);
  }

  public void desuscribir(Usuario usuario) {
    this.suscriptores.remove(usuario);
  }

  public void actualizar() {
    suscriptores.forEach(Usuario::actualizarSugerenciaDiaria);
  }
}
