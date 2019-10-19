import org.w3c.dom.Attr;
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
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class LectorXmlSax {
    public static void main(String[] args) {
        File fich = new File("carrito.xml");
        if (!fich.exists()){
            crearDocumento();
        }
        try {
             XMLReader procesador = XMLReaderFactory.createXMLReader();
             LectorXML lector = new LectorXML();
             procesador.setContentHandler(lector);
             InputSource fichero = new InputSource("carrito.xml");
             procesador.parse(fichero);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearDocumento(){
        Double[] preus = {12.0,2.50,6.25};
        String []nombres = {"Manzana","Pera","Pollo","Calabaza","Salsa","Leche"};
        int []cantidades = {2,4,3,8};
        Random rnd = new Random();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Elemento raiz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("carrito");
            doc.appendChild(rootElement);
            for (int i=0; i<nombres.length; i++) {
                //primer elemento
                Element producto = doc.createElement("producto");
                Attr atributo = doc.createAttribute("id");
                atributo.setValue(String.valueOf(i+1));
                rootElement.appendChild(producto);
                producto.setAttributeNode(atributo);

                //Agregamos los atributos
                Element nombre = doc.createElement("nombre");
                producto.appendChild(nombre);
                Text valorNombre = doc.createTextNode(nombres[i]);
                nombre.appendChild(valorNombre);

                Element precio = doc.createElement("precio");
                producto.appendChild(precio);
                Text valorPrecio = doc.createTextNode(String.valueOf(preus[rnd.nextInt(3)]));
                precio.appendChild(valorPrecio);

                Element cantidad = doc.createElement("cantidad");
                producto.appendChild(cantidad);
                Text valorCantidad = doc.createTextNode(String.valueOf(cantidades[rnd.nextInt(3)]));
                precio.appendChild(valorCantidad);

                //Se escribe el contenido del xml a un arxivo
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("./carrito.xml"));
                transformer.transform(source, result);
            }

        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
