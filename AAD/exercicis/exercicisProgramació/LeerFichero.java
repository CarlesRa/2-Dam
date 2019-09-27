import java.io.*;

public class LeerFichero{
    public static void main(String[] args) throws IOException{
        File fichero;
        BufferedReader lector;
        String linea;

        try{
            fichero = new File(args[0]);
            lector = new BufferedReader(new FileReader(fichero));
            while((linea = lector.readLine()) != null){
                System.out.println(linea);
            }
        }
        catch(FileNotFoundException fnfe){
            System.out.println("No se encuentra el fichero");
        }
    }
}