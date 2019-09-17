import java.io.IOException;
import java.io.File;
public class Exercici07{
    public static void main(String[] args){
        File directoriPrincipal = new File(".","Curs 2DAM");
        if(directoriPrincipal.mkdir()){
            File aval1 = new File(directoriPrincipal,"1AVAL");
            File aval2 = new File(directoriPrincipal, "2AVAL");
            File aval3 = new File(directoriPrincipal, "3AVAL");
            aval2.mkdir();
            aval3.mkdir();
        if(aval1.mkdir()){
                File examenMio = new File(aval1,"Examen Mio");
                File examenTuyo = new File(aval1, "Examen Tuyo");
                try{
                    examenMio.createNewFile();
                    examenTuyo.createNewFile();
                }catch(IOException ioe){
                    
                }

            }
            
        }
    }
}