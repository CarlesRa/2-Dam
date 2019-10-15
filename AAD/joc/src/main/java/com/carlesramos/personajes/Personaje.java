package com.carlesramos.personajes;

import com.carlesramos.armas.Arma;
import com.carlesramos.items.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Personaje implements Serializable {
    private static int IDAUTO = 0;
    private int id;
    private static final long serialVersionUID = 1L;
    private final int VIDABASE = 100;
    private String nom;
    private String tipo;//orc,elf,mag
    private int forsa;
    private int vida;
    private ArrayList<Arma> armes;
    private ArrayList<Item> motxila;

    public Personaje(String nom, String tipo) {
        id = ++IDAUTO;
        this.nom = nom;
        this.tipo = tipo;
        this.forsa = calcularForsa(tipo);
        this.vida = VIDABASE;
        this.armes = new ArrayList<>();
        this.motxila = new ArrayList<>();
        addArma(assignarArma(tipo));
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
        calcularForsa(tipo);
        assignarArma(tipo);
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

    public ArrayList<Arma> getArmes() {
        return armes;
    }

    public ArrayList<Item> getMotxila() {
        return motxila;
    }

    public void addItem(Item item) {
        motxila.add(item);
    }

    public void listarItems(){
        System.out.println(motxila);
    }

    public void addToMotxila(Item item) {
        this.motxila.add(item);
    }

    public void addArma(Arma arma) {
        armes.add(arma);
    }

    public int getid() {
        return id;
    }

    public int atacar(){
        int damage;
        Random random = new Random();
        damage = random.nextInt(21);
        return damage;
    }

    public static void setIDAUTO(int IDAUTO) {
        Personaje.IDAUTO = IDAUTO;
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
        if ("Orc".equalsIgnoreCase(tipo)) {
            arma = new Arma("Hacha del leñador");
        } else if ("Elf".equalsIgnoreCase(tipo)) {
            arma = new Arma("Arc de fusta");
        } else if ("Mag".equalsIgnoreCase(tipo)) {
            arma = new Arma("Varita de pluma de fenix");
        } else {
            arma = new Arma("punys");
        }
        return arma;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", VIDABASE=" + VIDABASE +
                ", nom='" + nom + '\'' +
                ", tipo='" + tipo + '\'' +
                ", forsa=" + forsa +
                ", vida=" + vida +
                ", armes=" + armes +
                ", motxila=" + motxila +
                '}';
    }
}
