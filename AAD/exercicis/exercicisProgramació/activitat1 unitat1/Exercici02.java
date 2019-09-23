import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Exercici02{
    public static void main(String[] args) throws IOException{
        File fichero1;
        File fichero2;
        BufferedReader lector;
        FileWriter escritor;
        String linea;
        try{
            fichero1 = new File("./f1.txt");
            fichero2 = new File("./f2.txt");
            lector = new BufferedReader(new FileReader(fichero1));
            escritor = new FileWriter(fichero2);
            
            while((linea = lector.readLine()) != null){
                escritor.write(linea + "\n");
            }
            lector.close();
            escritor.close();
        }catch(FileNotFoundException fnfe){
            System.out.println("No se encuentra el fichero");
        }
        
    }
}