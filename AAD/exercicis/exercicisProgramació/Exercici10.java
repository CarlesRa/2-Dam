import java.io.*;


public class Exercici10{
    public static void main(String[] args) {
       try{
            PrintWriter fichero = new PrintWriter(new File("/home/carles/Documentos/DAM/2º DAM/AAD/exercicis/exercicisProgramació/Curs 2DAM/f1.txt"));  
            for(int i=1; i<11; i++){
                fichero.println("Fila número: " + i); 
            }   
            fichero.close();
        } 
       catch(FileNotFoundException fnfe){
            System.out.println("No se encuentra el fichero...");
       }
      
    }
}