import java.io.BufferedReader;
import java.io.*;
public class Exercici07{
    public static void main(String[] args) throws IOException{
        File fichero;
        BufferedReader lector;
        String linea;
        String [] palabras;
        int numLineas;
        int numCaracteres;
        int numPalabras;
        try{
            fichero = new File(args[0]);
            lector = new BufferedReader(new FileReader(fichero));
            numLineas = 0;
            numCaracteres = 0;
            numPalabras = 0;
            while((linea = lector.readLine()) != null){
                numLineas++;
                palabras = linea.split(" ");
                numPalabras += palabras.length;
                numCaracteres += numCaractersSenseEspais(palabras);
            }
            System.out.println("En el fichero " + fichero.getName() + " hay:");
            System.out.println("Lineas: " + numLineas);
            System.out.println("Caracteres: " + numCaracteres);
            System.out.println("Palabras: " + numPalabras);
            lector.close();
        }
        catch(FileNotFoundException fnfe){
            System.out.println("No se encontro el fichero...");
        }
    } 
    
    public static int numCaractersSenseEspais(String[] s){
        StringBuilder sb = new StringBuilder();
        for(String aux : s){
            sb.append(aux);
        }
        return sb.length();
    }
}