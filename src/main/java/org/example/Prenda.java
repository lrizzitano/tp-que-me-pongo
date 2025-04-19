package org.example;

public class Prenda {
    private Tipo tipo;
    private String material;
    private Color colorPrincipal;
    private Color colorSecuandario;

    public Prenda(Tipo tipo, String material, Color colorPrincipal) {
        this(tipo, material, colorPrincipal, null);
    }

    public Prenda(Tipo tipo, String material, Color colorPrincipal, Color colorSecuandario) {
        this.tipo = tipo;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecuandario = colorSecuandario;
    }
}
