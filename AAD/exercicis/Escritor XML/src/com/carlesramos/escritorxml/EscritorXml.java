package com.carlesramos.escritorxml;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

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
import java.util.Random;

public class EscritorXml {
    public static void main(String[] args) {
        crearVariosPersonajesenXml();
    }

    public static void crearVariosPersonajesenXml(){
        String[] tipos = {"orc","elf","mag"};
        String []noms = {"Manolo","Juana","Mariflor","Esperanto","Martinez","El facha","Carmena","Juanita","Menganita"};
        Random rnd = new Random();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Elemento raiz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Personajes");
            doc.appendChild(rootElement);
            for (int i=0; i<noms.length; i++) {
                //primer elemento
                Element personaje = doc.createElement("Personaje");
                rootElement.appendChild(personaje);

                //Agregamos los atributos
                Element nombre = doc.createElement("nombre");
                personaje.appendChild(nombre);
                Text valorNombre = doc.createTextNode(noms[i]);
                nombre.appendChild(valorNombre);

                Element tipo = doc.createElement("tipo");
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

        }catch (ParserConfigurationException | TransformerConfigurationException pcce){


        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
