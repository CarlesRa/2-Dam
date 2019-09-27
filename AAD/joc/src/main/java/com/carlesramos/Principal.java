package com.carlesramos;

import com.carlesramos.personajes.Personaje;

public class Principal {
    public static void main(String[] args) {
        Personaje orc = new Personaje("Orc verd","Orc");
        Personaje elf = new Personaje("Elf de la melena","Elf");
        Personaje mag = new Personaje("Harry el mag","Mag");

        System.out.println(orc.toString());
        System.out.println(elf.toString());
        System.out.println(mag.toString());
    }
}
