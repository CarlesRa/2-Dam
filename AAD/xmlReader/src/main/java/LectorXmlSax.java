import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class LectorXmlSax {
    public static void main(String[] args) {
        try {
             XMLReader procesador = XMLReaderFactory.createXMLReader();
             LectorXML lector = new LectorXML();
             procesador.setContentHandler(lector);
             InputSource fichero = new InputSource("empleados.xml");
             procesador.parse(fichero);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearDocumento(){
        String[] tipos = {"orc","elf","mag"};
        String []noms = {"Manolo","Juana","Mariflor","Esperanto","Martinez","El facha","Carmena","Juanita","Menganita"};
        Random rnd = new Random();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Elemento raiz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("carrito");
            doc.appendChild(rootElement);
            for (int i=0; i<noms.length; i++) {
                //primer elemento
                Element personaje = doc.createElement("producto");
                rootElement.appendChild(personaje);

                //Agregamos los atributos
                Element nombre = doc.createElement("nombre");
                personaje.appendChild(nombre);
                Text valorNombre = doc.createTextNode(noms[i]);
                nombre.appendChild(valorNombre);

                Element tipo = doc.createElement("precio");
                personaje.appendChild(tipo);
                Text valorTipo = doc.createTextNode(tipos[rnd.nextInt(3)]);
                tipo.appendChild(valorTipo);

                Element tipo = doc.createElement("precio");
                personaje.appendChild(tipo);
                Text valorTipo = doc.createTextNode(tipos[rnd.nextInt(3)]);
                tipo.appendChild(valorTipo);

                //Se escribe el contenido del xml a un arxivo
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("./Personajes.xml"));
                transformer.transform(source, result);
            }

        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
