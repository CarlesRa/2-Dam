import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Exercici06{
    public static void main(String[] args) throws IOException{
        File fichero;
        BufferedReader lector;
        int nLineasUsuario;
        Scanner scaner;
        boolean esCorrecto;
        ArrayList <String> arrayLineas;
        String linea;
        int numLineas;
        scaner = new Scanner(System.in);
        nLineasUsuario = 0;
        esCorrecto = false;
        arrayLineas = new ArrayList<>();
        numLineas = 0;
        try{
            fichero = new File(args[0]);
            lector = new BufferedReader(new FileReader(fichero));   
            while(!esCorrecto){
                System.out.print("Cuantas lineas desea ver?: ");
                try{
                    nLineasUsuario = scaner.nextInt();
                    scaner.nextLine();
                    while((linea = lector.readLine()) != null){
                        arrayLineas.add(linea);
                        numLineas++;
                    }
                    try{
                        for(int i=(numLineas - nLineasUsuario);i<numLineas;i++){
                            System.out.println(arrayLineas.get(i));
                        }
                        esCorrecto = true;
                    }
                    catch(IndexOutOfBoundsException iobe){
                        System.out.println("Has superado el numero de lineas!!"
                        + " El fichero tiene " + numLineas + " lineas.");
                        esCorrecto = false;
                    }
                }
                catch(InputMismatchException imme){
                    System.out.println("Tienes que poner un numero....");
                    esCorrecto = false;
                    scaner.nextLine();
                }                
            }
            lector.close();  
        }
        catch(FileNotFoundException fnfe){
            System.out.println("No se encuentra el fichero, Adioss");
            esCorrecto = true;
        }     
    }
}