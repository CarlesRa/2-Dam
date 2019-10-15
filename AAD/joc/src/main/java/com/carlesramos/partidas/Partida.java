package com.carlesramos.partidas;

import com.carlesramos.personajes.Personaje;

import java.io.Serializable;
import java.util.Random;

public class Partida implements Serializable {
    private static int idAuto;
    private int id;
    private Personaje[] personajes;

    public Partida() {
        id = ++idAuto;
        personajes = new Personaje[2];
        personajesAleatorios();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personaje[] getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Personaje[] personajes) {
        this.personajes = personajes;
    }

    public void personajesAleatorios(){
        Random rnd = new Random();
        String[] nombres = {"Manolo","Mariola","Juana","Arturo"};
        String [] raza = {"orc","mag","elf"};
        for (int i=0; i<personajes.length; i++){
            personajes[i] = new Personaje(nombres[rnd.nextInt(nombres.length)],raza[rnd.nextInt(raza.length)]);
        }
    }

    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id + " " +
                 personajes[0].getNom() +
                " Vida:" + personajes[0].getVida() + " " +
                personajes[1].getNom() +
                " Vida:" + personajes[1].getVida() +
        '}'+"\n";
    }
}
