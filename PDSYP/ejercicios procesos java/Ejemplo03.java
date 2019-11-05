import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.Exception;

public class Ejemplo03{
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        String[] command = {"/bin/bash","-C","java Unsaludo \"Buenas noches Portugal!!\""};
        Process process = null;

        /*if(args.length < 1){
            System.out.println("NO se han pasado parámetos...");
            System.exit(1);
        }*/
        try{
            File fichero = new File("RecolectorDeSaludo.txt");
            PrintWriter print = new PrintWriter(fichero) ;
            process = runtime.exec(command);
            InputStream inputS = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputS));
            String linea;
            while( (linea = br.readLine()) != null){
                print.write(linea);
            }

            print.close();
            br.close();
            inputS.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}