package com.carlesramos.leerxml;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.sound.midi.Soundbank;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LecturaXml {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            Document document;
            DocumentBuilder builder=factory.newDocumentBuilder();
            document= builder.parse(new File("empleado.xml"));
            document.getDocumentElement().normalize();
            System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName("empleado");
            System.out.println("Hay " + nodeList.getLength() + " Empleados");

            for (int i=0; i<nodeList.getLength(); i++){
                Node nodo = nodeList.item(i);
                System.out.println("Elemento: " + nodo.getNodeName());
                if (nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) nodo;
                    System.out.println("------------------------------------");
                    System.out.println("id: " + element.getAttribute("id"));
                    System.out.println("nombre: " + element.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Apellido: " + element.getElementsByTagName("apellidos").item(0).getTextContent());
                    System.out.println("------------------------------------\n");
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
