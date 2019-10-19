import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

public class MainLeer {
	public static void main(String[] args) {
        XStream xs = new XStream();
        xs.processAnnotations(Alumne.class);
        try {
            FileInputStream importar = new FileInputStream("alumnes.xml");
            ArrayList<Alumne>alumnes;
            alumnes = (ArrayList<Alumne>) xs.fromXML(importar);
            for (Alumne a: alumnes) {
                System.out.println(a.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
