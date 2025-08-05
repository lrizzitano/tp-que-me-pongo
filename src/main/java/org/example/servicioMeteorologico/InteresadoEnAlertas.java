package org.example.servicioMeteorologico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.example.usuario.Usuario;

public abstract class InteresadoEnAlertas {
  protected List<Usuario> suscriptores;

  public InteresadoEnAlertas() {
    suscriptores = new ArrayList<Usuario>();
  }

  public void suscribir(Usuario usuario) {
    suscriptores.add(usuario);
  }

  public void desuscribir(Usuario usuario) {
    suscriptores.remove(usuario);
  }

  abstract public void anteAlerta(HashMap<String, List<String>> alertas);
}
