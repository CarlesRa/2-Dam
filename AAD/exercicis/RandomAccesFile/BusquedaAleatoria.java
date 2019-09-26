import java.io.*;
public class BusquedaAleatoria{
    public static void main(String[] args) throws IOException{
        File f1;
        RandomAccessFile randomAccessFile;
        int id;
        int departamento;
        int puntero;
        double salario;
        char [] apellido;
        String apellidos;
        int sice;
        f1 = new File("./Empleados.dat");
        randomAccessFile = new RandomAccessFile(f1, "r");
        puntero = 0;
        apellido = new char[10];
        sice = 36;
        while(randomAccessFile.length() != randomAccessFile.getFilePointer()){
            randomAccessFile.seek(puntero);
            id = randomAccessFile.readInt();
            for(int i=0; i<apellido.length; i++){
                apellido[i] = randomAccessFile.readChar();
            }
            apellidos = new String(apellido);
            departamento = randomAccessFile.readInt();
            salario = randomAccessFile.readDouble();
            if(id > 0){
                System.out.printf("id: %d, apellido: %s, departamento: %d, salario: %.2f\n"
                ,id,apellidos.trim(),departamento,salario);
            }
            puntero += sice;
        }
        randomAccessFile.close();
    }
}