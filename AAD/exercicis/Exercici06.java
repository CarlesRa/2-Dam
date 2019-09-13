

import java.io.File;

public class Exercici06{
    public static void main(String[] args) {
        String path = args[0];
        File [] lista;
        File dir = new File(path);
        lista = dir.listFiles();
        System.out.println(dir.getName());
        for(File f1 : lista){
            if(f1.isDirectory()){
                File dir2 = new File(f1.getName());
                File [] lista2 = dir2.listFiles();
                System.out.println("\t" + dir2.getName());
                for(File f2 : lista2){
                    System.out.printf("\t\t" + f2.getName() + "\n");
                }
                
            }
            else    
                System.out.println("\t" + f1.getName());
        }
    }

}