import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Exercici04{
    public static void main(String[] args) throws IOException{
        File fichero;
        BufferedReader lector;
        int contadorLineas;
        fichero = new File(args[0]);
        lector = new BufferedReader(new FileReader(fichero));//abrimos el flujo de entrada
        contadorLineas = 0;
        while (lector.readLine() != null){
            contadorLineas++;
        }
        lector.close();//cerramos el flujo
        System.out.println("En el fichero " + fichero.getName() + " que esta en: "
         + fichero.getAbsolutePath()+ " hay: " + contadorLineas + " lineas.");
    }
}