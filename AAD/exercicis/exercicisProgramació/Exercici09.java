import java.io.*;
import java.util.Scanner;
public class Exercici09{
    public static void main(String[] args) throws IOException{
        Scanner lec = new Scanner(System.in);
        File f = new File(args[0]);
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