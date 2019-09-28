package com.carlesramos;

import com.carlesramos.armas.Arma;
import com.carlesramos.personajes.Personaje;

import java.io.*;

public class Principal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File fichero;
        FileOutputStream ficheroSalida;
        FileInputStream ficheroEntrada;
        ObjectOutputStream escritor;
        ObjectInputStream lectorObjetos;
        boolean hayMas = true;
        fichero = new File("joc.dat");
        ficheroSalida = new FileOutputStream(fichero);
        escritor = new ObjectOutputStream(ficheroSalida);
        ficheroEntrada = new FileInputStream(fichero);
        lectorObjetos = new ObjectInputStream(ficheroEntrada);
        Personaje orc = new Personaje("Orc verd","Orc");
        Personaje elf = new Personaje("Elf de la melena","Elf");
        Personaje mag = new Personaje("Harry el mag","Mag");

        System.out.println(orc.toString());
        System.out.println(elf.toString());
        System.out.println(mag.toString());

        orc.setArmes(new Arma("Espasa a dos mans"));

        escritor.writeObject(orc);
        escritor.writeObject(elf);
        escritor.writeObject(mag);

        while(hayMas){
            try {
                System.out.println(lectorObjetos.readObject().toString());
            }
            catch (EOFException eofe){
                hayMas = false;
            }
        }
    }
}
