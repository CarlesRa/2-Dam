package com.carlesramos;

import com.carlesramos.armas.Arma;
import com.carlesramos.personajes.Personaje;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.util.ArrayList;

public class Principal {
    static File fichero = fichero = new File("joc.dat");
    static ArrayList<Personaje>personajes = new ArrayList<>();
    public static void main(String[] args) throws IOException, ClassNotFoundException {


    }

    public static void mostrarMenu(){
        System.out.println("******MENU PRINCIPAL*******");
        System.out.println("1-Crear personajes");
        System.out.println("2-Ver ");
        System.out.println("******MENU PRINCIPAL*******");
    }

    public static int cargarJuego(){
        int contador = 0;
        boolean hayMas;
        FileInputStream ficheroEntrada;
        ObjectInputStream lectorObjetos = null;
        hayMas = false;
        try {
            ficheroEntrada = new FileInputStream(fichero);
            lectorObjetos = new ObjectInputStream(ficheroEntrada);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado....");
        } catch (IOException ioe){
            System.out.println("Error de entrada/salida...");
        }

        while(hayMas){
            try {
               personajes.add((Personaje) lectorObjetos.readObject());
               contador++;
            } catch (IOException e) {
                System.out.println("Error de entada/salida");
            } catch (ClassNotFoundException e) {
                System.out.println("Fichero no encontrado");
            }
        }
        return contador;
    }

    public void guardarJuego(){
        FileOutputStream ficheroSalida;
        ObjectOutputStream escritor;
        try {
            ficheroSalida = new FileOutputStream(fichero);
            escritor = new ObjectOutputStream(ficheroSalida);
            for (int i=0; i<personajes.size(); i++){
                escritor.writeObject(personajes.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero...");
        }catch (IOException ioe){
            System.out.println("Error de entrada/salida");
        }

    }
}
