package com.carlesramos;

import com.carlesramos.personajes.Personaje;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static File fichero = fichero = new File("joc.dat");
    static ArrayList<Personaje>personajes = new ArrayList<>();
    static Scanner lec = new Scanner(System.in);

    public static void main(String[] args)  {
        int numPersonjes;
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
                default:
                    System.out.println("Eleccion Incorrecta");
                    break;
            }
        }while (eleccionMenu != 3);



    }

    public static int mostrarMenu(){
        int eleccion = -1;
        System.out.println("******MENU PRINCIPAL*******");
        System.out.println("1-Listar personajes");
        System.out.println("2-Crear personajes");
        System.out.println("3-Guardar y salir");
        System.out.println("4-Borrar personaje");
        System.out.println("5-Modificar Jugador");
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
        System.out.println("Introduce el ID: ");
        id = lec.nextInt();
        lec.nextLine();
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
        System.out.println("Introduce el ID:");
        id = lec.nextInt();
        lec.nextLine();
        for(int i=0; i<personajes.size(); i++){
            if (personajes.get(i).getid() == id){
                personajes.remove(i);
            }
        }
    }
}
