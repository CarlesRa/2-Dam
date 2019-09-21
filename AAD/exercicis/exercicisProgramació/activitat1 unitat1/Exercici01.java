import java.io.BufferedReader;

import java.io.*;

public class Exercici01{
    public static void main(String[] args) throws IOException {
        File fichero;
        BufferedReader lector; 
        String linea;
        fichero = new File("/home/carles/Documentos/DAM/2º DAM/AAD/exercicis/exercicisProgramació/Curs 2DAM/f1.txt");
        lector = new BufferedReader(new FileReader(fichero));
        while((linea = lector.readLine()) != null){
            mostrarAlReves(linea);
        }
        lector.close();

        
    }
    public static void mostrarAlReves(String s){
        for(int i=s.length()-1; i>=0; i--){
            System.out.print(s.charAt(i));
            if(i == 0){
                System.out.println();
            }
        }
    }
}