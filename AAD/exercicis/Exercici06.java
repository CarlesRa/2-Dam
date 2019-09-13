import java.util.ArrayList;
import java.util.List;



import java.io.File;

public class Exercici06{
    static ArrayList <String> directorios;
    static ArrayList <String> archivos;
    public static void main(String[] args) {
        directorios = new ArrayList<>();
        archivos = new ArrayList<>(); 
        String path = args[0];
        File file = new File(path);
        System.out.println("Directorio de búsqueda: " + file.getAbsolutePath());
        verArchivosRecursivamente(file);
        System.out.println("Los archivos existentes son:");
        imprimirLista(archivos);
        System.out.println("Los directorios existentes son:");
        imprimirLista(directorios);
       
    }
    public static void verArchivosRecursivamente(File file){
        File [] lista;
        lista = file.listFiles();
        for(File f1 : lista){
            if(f1.isDirectory()){
                directorios.add(f1.getName());
                verArchivosRecursivamente(f1);
            }
            else    
            archivos.add(f1.getName());
        }
    }
    public static void imprimirLista(List <String> lista){
        for (String aux : lista){
            System.out.println("\t" + aux);
        }
    }
}