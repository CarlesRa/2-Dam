import java.io.*;

public class EscribirEmpleados{
    public static void main(String[] args) throws IOException{
        File f1;
        String []apellido = {"Ramos","Gutierrez","Ferrandiz","Manolo"};
        int []departamento = {12,25,23,56};
        Double []salario = {2.23,4.54,3.56,9.25};
        RandomAccessFile randomAccessFile;
        StringBuffer buffer = null;
        f1 = new File("./Empleados.dat");
        randomAccessFile = new RandomAccessFile(f1, "rw");
        for(int i=0; i<apellido.length; i++){
            buffer = new StringBuffer(apellido[i]);
            buffer.setLength(10);
            randomAccessFile.writeInt(i+1);
            randomAccessFile.writeChars(buffer.toString());
            randomAccessFile.writeInt(departamento[i]);
            randomAccessFile.writeDouble(salario[i]);
        }
        randomAccessFile.close();
    }
}