package com.carlesramos;

import com.carlesramos.items.Item;
import com.carlesramos.partidas.Partida;
import com.carlesramos.personajes.Personaje;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Principal {

    static File fichero = fichero = new File("joc.dat");
    static ArrayList<Personaje>personajes = new ArrayList<>();
    static Scanner lec = new Scanner(System.in);

    public static void main(String[] args)  {
        int eleccionMenu;
        try {
            cargarJuego();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException cnfe){

        }
        if (personajes.size() == 0){
            System.out.println("No hay personajes con los que jugar...");
        }
        else{
            System.out.println("Hay un total de " + personajes.size() + " personajes\n");
        }
        do {
            eleccionMenu = mostrarMenu();
            switch (eleccionMenu){
                case 1:{
                    listarPersonajes();
                    break;
                }
                case 2:{
                    crearPersonaje();
                    break;
                }
                case 3:{
                    guardarJuego();
                    break;
                }

                case 4:{
                    borrarPersonaje();
                    break;
                }
                case 5:{
                    modificarJugador();
                    break;
                }
                case 6:{
                    nuevoItem();
                    break;
                }
                case 7:{
                    listarItemPersonaje();
                    break;
                }
                case 8:{
                    try {
                        partidaAutomatica();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 9:{
                    try {
                        verPartidasGuardadas();
                    } catch (IOException e) {

                    }
                    break;
                }
            }
        }while (eleccionMenu != 3);
    }

    public static int mostrarMenu(){
        int eleccion;
        System.out.println("******MENU PRINCIPAL*******");
        System.out.println("1-Listar personajes");
        System.out.println("2-Crear personajes");
        System.out.println("3-Guardar y salir");
        System.out.println("4-Borrar personaje");
        System.out.println("5-Modificar personaje");
        System.out.println("6-Añadir Item");
        System.out.println("7-Listar Item personaje");
        System.out.println("8-Partida automática");
        System.out.println("9-Ver partidas guardadas");
        System.out.println("Selecciona una opción: ");
        eleccion = lec.nextInt();
        lec.nextLine();
        return eleccion;
    }



    public static void cargarJuego() throws IOException,ClassNotFoundException{
        boolean salir = false;
        int id = Integer.MIN_VALUE;
        int i = 0;
        if (!fichero.exists()){
            fichero.createNewFile();
        }
        try {
            FileInputStream ficheroEntrada = new FileInputStream(fichero);
            ObjectInputStream lectorObjetos = new ObjectInputStream(ficheroEntrada);
            while (!salir) {
                personajes.add((Personaje) lectorObjetos.readObject());
                if (id < personajes.get(i).getid()){
                    id = personajes.get(i).getid();
                }
                i++;

            }
            lectorObjetos.close();
        }catch (EOFException eof){
            Personaje.setIDAUTO(id);
        }

    }

    public static void crearPersonaje(){
        String nombre;
        String tipo;
        System.out.println("Nombre: ");
        nombre = lec.nextLine();
        System.out.println("Tipo: ");
        tipo = lec.nextLine();
        personajes.add(new Personaje(nombre,tipo));
    }

    public static void listarPersonajes(){
        personajes.forEach(personaje -> System.out.println(personaje.toString()));
    }

    public static void borrarPersonaje(){
        int id;
        id = pedirId();
        for (int i=0; i<personajes.size(); i++){
            if (personajes.get(i).getid() == id){
                personajes.remove(i);
                System.out.println("Personaje borrado con éxito");
                return;
            }
        }
        System.out.println("No existe personaje con ese ID...");
    }

    public static void guardarJuego(){
        try {
            FileOutputStream ficheroSalida;
            ObjectOutputStream escritor;
            ficheroSalida = new FileOutputStream(fichero);
            escritor = new ObjectOutputStream(ficheroSalida);
            personajes.forEach(personaje -> {
                try {
                    escritor.writeObject(personaje);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException ioe){
            System.out.println("Error de entrada/salida");
        }
    }
    public static void modificarJugador(){
        int id;
        String nombre;
        int posicion = 0;
        boolean encontrado = false;
        id = pedirId();
        for(int i=0; i<personajes.size(); i++){
            if (personajes.get(i).getid() == id){
                System.out.println("Personaje encontrado!!");
                posicion = i;
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("Ningun personaje con ese ID....");
        }
        else {
            System.out.println("Indique el nuevo nombre: ");
            nombre = lec.nextLine();
            personajes.get(posicion).setNom(nombre);

        }
    }
    public static void nuevoItem(){
        int id;
        int posicion;
        String nomItem;
        String descripcion;
        id = pedirId();
        for (int i=0; i<personajes.size(); i++){
            if (personajes.get(i).getid() == id){
                personajes.get(i).toString();
                System.out.println("Introduce el nombre del item:");
                nomItem = lec.nextLine();
                System.out.println("Introduce la descripcion:");
                descripcion = lec.nextLine();
                personajes.get(i).addItem(new Item(nomItem,descripcion));
            }
        }
    }

    public static void listarItemPersonaje(){
        int id;
        id = pedirId();
        for (int i=0; i<personajes.size(); i++){
            if (personajes.get(i).getid() == id){
                personajes.get(i).listarItems();
            }
        }
    }

    public static void partidaAutomatica() throws IOException {
        File partidaGuardada = new File("partidaGuardada.dat");
        if (!partidaGuardada.exists()){
            partidaGuardada.createNewFile();
        }
        FileOutputStream partidaOut = new FileOutputStream(partidaGuardada);
        ObjectOutputStream guardar = new ObjectOutputStream(partidaOut);
        Random rnd = new Random();
        Partida partida  = new Partida();
        System.out.println("Players:");
        System.out.println(partida.getPersonajes()[0].getNom() + " VS " + partida.getPersonajes()[1].getNom());
        while(partida.getPersonajes()[0].getVida() > 0 || partida.getPersonajes()[1].getVida() > 0){
            System.out.print(partida.getPersonajes()[0].getNom() + ", Vida: " + partida.getPersonajes()[0].getVida() + "  ");
            System.out.println(partida.getPersonajes()[1].getNom() + ", Vida: " + partida.getPersonajes()[1].getVida());
            System.out.println("Ataca " + partida.getPersonajes()[0].getNom());
            partida.getPersonajes()[1].setVida(partida.getPersonajes()[1].getVida() - partida.getPersonajes()[0].atacar());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ataca " + partida.getPersonajes()[1].getNom());
            partida.getPersonajes()[0].setVida(partida.getPersonajes()[0].getVida() - partida.getPersonajes()[1].atacar());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (partida.getPersonajes()[1].getVida() <= 0){
                System.out.print(partida.getPersonajes()[0].getNom() + " Vida: " + partida.getPersonajes()[0].getVida() + "  ");
                System.out.println(partida.getPersonajes()[1].getNom() + " Vida: " + partida.getPersonajes()[1].getVida());
                System.out.println("VICTORIA!! GANADOR:");
                System.out.println(partida.getPersonajes()[0].getNom());
                guardar.writeObject(partida);
                partidaOut.close();
                guardar.close();
                return;
            }
            if (partida.getPersonajes()[0].getVida() <= 0){
                System.out.print(partida.getPersonajes()[0].getNom() + " Vida: " + partida.getPersonajes()[0].getVida() + "  ");
                System.out.println(partida.getPersonajes()[1].getNom() + " Vida: " + partida.getPersonajes()[1].getVida());
                System.out.println("VICTORIA!! GANADOR:");
                System.out.println(partida.getPersonajes()[1].getNom());
                guardar.writeObject(partida);
                partidaOut.close();
                guardar.close();
                return;
            }
        }
    }

    public static void verPartidasGuardadas() throws IOException {
        File partidaGuardada = new File("partidaGuardada.dat");
        boolean salir = false;
        ArrayList<Partida>partidas = new ArrayList<>();
        if (!partidaGuardada.exists()){
            partidaGuardada.createNewFile();
        }
        try {
            FileInputStream ficheroEntrada = new FileInputStream(partidaGuardada);
            ObjectInputStream lectorObjetos = new ObjectInputStream(ficheroEntrada);
            while (!salir) {
                partidas.add((Partida)lectorObjetos.readObject());
            }
            lectorObjetos.close();
            ficheroEntrada.close();
        }catch (EOFException | ClassNotFoundException eof){
            partidas.forEach(partida -> System.out.println(partida.toString()));
        }
    }

    public static int pedirId(){
        int id;
        System.out.println("Introduce el ID:");
        try {
            id = lec.nextInt();
            lec.nextLine();
            return id;

        }catch (NumberFormatException nfe){
            System.out.println("Solo se aceptan números...");
            return -1;
        }
    }

}
