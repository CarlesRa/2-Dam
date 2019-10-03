package com.carlesramos.personajes;

import com.carlesramos.armas.Arma;
import com.carlesramos.items.Item;

import java.io.Serializable;
import java.util.ArrayList;

public class Personaje implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int VIDABASE = 100;
    private String nom;
    private String tipo;//orc,elf,mag
    private int forsa;
    private int vida;
    private ArrayList<Arma> armes;
    private ArrayList<Item> motxila;

    public Personaje(String nom, String tipo) {
        this.nom = nom;
        this.tipo = tipo;
        this.forsa = calcularForsa(tipo);
        this.vida = VIDABASE;
        this.armes = new ArrayList<>();
        this.motxila = new ArrayList<>();
        setArmes(assignarArma(tipo));
    }

    public Personaje() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getForsa() {
        return forsa;
    }

    public void setForsa(int forsa) {
        this.forsa = forsa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Arma getArmes(int posicion) {
        return armes.get(posicion);
    }

    public Item getItem(int posicion) {
        return motxila.get(posicion);
    }

    public void addToMotxila(Item item) {
        this.motxila.add(item);
    }

    public void setArmes(Arma arma) {
        armes.add(arma);
    }

    private int calcularForsa(String tipo){
        int forsa = 0;
        if ("Orc".equals(tipo)) {
            forsa = 70;
        } else if ("Elf".equals(tipo)) {
            forsa = 40;
        } else if ("Mag".equals(tipo)) {
            forsa = 30;
        } else {
            forsa = 50;
        }
        return forsa;
    }

    private Arma assignarArma(String tipo){
        Arma arma;
        if ("Orc".equals(tipo)) {
            arma = new Arma("Hacha del leñador");
        } else if ("Elf".equals(tipo)) {
            arma = new Arma("Arc de fusta");
        } else if ("Mag".equals(tipo)) {
            arma = new Arma("Varita de pluma de fenix");
        } else {
            arma = new Arma("punys");
        }
        return arma;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nom='" + nom + '\'' +
                ", tipo='" + tipo + '\'' +
                ", força=" + forsa +
                ", vida=" + vida +
                ", armes=" + armes +
                '}';
    }
}
