package testswing;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File fichero;
        BufferedReader lector;
        int nLineasUsuario;
        Scanner scaner;
        boolean esCorrecto;
        ArrayList<String> arrayLineas;
        String linea;
        int numLineas;
        scaner = new Scanner(System.in);
        nLineasUsuario = 0;
        esCorrecto = false;
        arrayLineas = new ArrayList();
        numLineas = 0;
        try{
            fichero = new File("./f2.txt");
            lector = new BufferedReader(new FileReader(fichero));
            while(!esCorrecto){
                System.out.print("Cuantas lineas desea ver?: ");
                try{
                    nLineasUsuario = scaner.nextInt();
                    scaner.nextLine();
                }
                catch(NumberFormatException nfe){
                    System.out.println("Tienes que poner un numero....");
                    esCorrecto = false;
                }
                while((linea = lector.readLine()) != null){
                    arrayLineas.add(linea);
                    numLineas++;
                }
                if(numLineas < nLineasUsuario){
                    System.out.println("El fichero contiene menos lineas de las solicitadas....");
                    esCorrecto = false;
                    numLineas = 0;
                }
                else{
                    esCorrecto = true;
                    for(int i=(numLineas - nLineasUsuario);i<numLineas;i++){
                        System.out.println(arrayLineas.get(i));
                    }
                }
            }
        }
        catch(FileNotFoundException fnfe){
            System.out.println("No se encuentra el fichero, Adioss");
            esCorrecto = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

