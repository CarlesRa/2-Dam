import java.io.*;

public class DataEntradaEixida {

    public static void main(String[] args) throws IOException {
        File fichero= new File("FicheroTipoData");
        FileOutputStream fileOut=new FileOutputStream(fichero);
        FileInputStream fileIn=new FileInputStream(fichero);
        DataOutputStream dataOut=new DataOutputStream(fileOut);
        DataInputStream dataIn=new DataInputStream(fileIn);
        String[] noms= {"Paco","Crhistian","Juan","Manolo"};
        int[] edad= {32,33,26,27};

        for (int i =0;i<edad.length;i++){
            dataOut.writeUTF(noms[i]);
            dataOut.writeInt(edad[i]);
        }

        while(dataIn.available()>0){
            System.out.print("Nombre: " + dataIn.readUTF());
            System.out.println(", Edad: " + dataIn.readInt());
        }
        dataIn.close();
        dataOut.close();
    }
}