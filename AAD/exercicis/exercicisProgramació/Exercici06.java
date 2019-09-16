import java.util.List;
import java.io.File;

public class Exercici06{
    public static void main(String[] args) {
        String path = args[0];
        File file = new File(path);
        System.out.println("Directorio de busqueda: " + file.getAbsolutePath() + "\n");
        verArchivosRecursivamente(file);
    }
    public static void verArchivosRecursivamente(File file){
        File [] lista;
        lista = file.listFiles();
        for(File f1 : lista){
            if(f1.isDirectory()){
                System.out.println("DIRECTORIO: ");
                System.out.println(f1.getAbsolutePath());
                verArchivosRecursivamente(f1);
            }
            else {
                System.out.println("\t" + f1.getAbsolutePath());
            }       
        }
    }
}