import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Exercici05{
    public static void main(String[] args) throws IOException{
        BufferedReader lector;
        File fichero;
        String linea;
        Scanner lec;
        int numeroDeLineas;
        try{
            fichero = new File(args[0]);
            //abrimos el flufo de entrada
            lector = new BufferedReader(new FileReader(fichero));
            lec = new Scanner(System.in);
            System.out.print("Cueantas lineas desea ver?: ");
            numeroDeLineas = lec.nextInt();
            lec.nextLine();
            for(int i=0; i<numeroDeLineas; i++){
                //comprobamos que no sea null
                if((linea = lector.readLine()) != null){
                    System.out.println(linea);
                }
                //si llegamos a null mostramos el mensaje de que no hay mas lineas
                else{
                    System.out.println("\u001B[31m El numero total de lineas es: \u001B[32m" 
                    + i + "\u001B[31m No hay mas lineas que mostrar!!\u001B[0m");
                    lector.close();
                    return;
                }
            }
        //cerramos el flujo
        lector.close();
        }
        catch(NumberFormatException nfe){
            System.out.println("Fichero no encontrado....");
        }
    }
}