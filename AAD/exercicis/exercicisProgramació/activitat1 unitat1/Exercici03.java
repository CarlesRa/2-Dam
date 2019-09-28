import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
public class Exercici03{
    public static void main(String[] args) throws IOException {
        File fichero1;
        File fichero2;
        BufferedReader lector;
        FileWriter escritor;
        String linea;
        try{
            fichero1 = new File(args[0]);
            fichero2 = new File(args[1]);
            lector = new BufferedReader(new FileReader(fichero1));
            escritor = new FileWriter(fichero2,true);
            while((linea = lector.readLine()) != null){
                escritor.write("\n" + linea);
            }
            lector.close();
            escritor.close();
        }catch(FileNotFoundException fnfe){
            System.out.println("No se encuentra el fichero");
        }
    }
}