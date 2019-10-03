package com.carlesramos.items;

public class Item {
    private String nom;
    private String desripcio;

    public Item(String nom, String desripcio) {
        this.nom = nom;
        this.desripcio = desripcio;
    }

    public Item() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesripcio() {
        return desripcio;
    }

    public void setDesripcio(String desripcio) {
        this.desripcio = desripcio;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nom='" + nom + '\'' +
                ", desripcio='" + desripcio + '\'' +
                '}';
    }
}
