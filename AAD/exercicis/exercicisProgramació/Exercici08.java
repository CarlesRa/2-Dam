import java.io.*;
public class Exercici08{
    public static void main(String[] args) throws IOException {
        File f = new File("/home/carles/Documentos/DAM/2º DAM/AAD/exercicis/exercicisProgramació/Curs 2DAM/f1.txt");
        FileReader fRead = new FileReader(f);
        int i;
        while((i = fRead.read()) != -1){
            System.out.println((char)i + "==>" + i);
        }
        fRead.close();
    }
}