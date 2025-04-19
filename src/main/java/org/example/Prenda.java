package org.example;

import static java.util.Objects.requireNonNull;

public class Prenda {
    private Tipo tipo;
    private String material;
    private Color colorPrincipal;
    private Color colorSecuandario;

    public Prenda(Tipo tipo, String material, Color colorPrincipal) {
        this(tipo, material, colorPrincipal, null);
    }

    public Prenda(Tipo tipo, String material, Color colorPrincipal, Color colorSecuandario) {
        this.tipo = requireNonNull(tipo, "El tipo de prenda es obligatiorio");
        this.material = requireNonNull(material, "El material de la prenda es obligatorio");
        this.colorPrincipal = requireNonNull(colorPrincipal, "El color principal de prenda es obligatorio");
        this.colorSecuandario = colorSecuandario;
    }
}
