import com.thoughtworks.xstream.XStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alumne> alumnes = new ArrayList<Alumne>();
        Alumne al1 = new Alumne("Paco","Vives",25,3.65);
        Alumne al2 = new Alumne("Soralla","Vives",32,7.5);
        alumnes.add(al1);
        alumnes.add(al2);
        XStream xs = new XStream();
        try {
            FileOutputStream desti = new FileOutputStream("alumnes.xml");
            //indiquem que estem gastant anotacions
            xs.processAnnotations(Alumne.class);
            xs.toXML(alumnes,desti);
            System.out.println("Funciona");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
