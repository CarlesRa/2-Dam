import java.io.*;
import java.util.Scanner;
public class Exercici09{
    public static void main(String[] args) throws IOException{
        Scanner lec = new Scanner(System.in);
        File f = new File("/home/carles/Documentos/DAM/2º DAM/AAD/exercicis/exercicisProgramació/Curs 2DAM/f1.txt");
        FileWriter fW = new FileWriter(f);
        char caracter;
        do{
            System.out.print("Introduce un caracter: ");
            caracter = lec.next().charAt(0);
            if(caracter != '\\'){
                fW.write(caracter);
            }
        }while (caracter != '\\');
        fW.close();
    }
}