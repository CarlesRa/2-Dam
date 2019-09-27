package com.carlesramos.armas;

import java.io.Serializable;

public class Arma implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int VIDABASE = 100;

    private String nom;
    private int vida;

    public Arma(String nom) {
        this.nom = nom;
        this.vida = VIDABASE;
    }

    public Arma() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "nom='" + nom + '\'' +
                ", vida=" + vida +
                '}';
    }
}
