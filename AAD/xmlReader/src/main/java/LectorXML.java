import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LectorXML extends DefaultHandler {

    public LectorXML() {
    }


    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"\n <!--inici document XML-->");
    }

    public void endDocument(){
        System.out.println("<!-- fin document xml-->");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        System.out.println("<" + localName + ">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println("</" + localName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String cadena = new String(ch,start,length);
        System.out.println(cadena);
    }
}
