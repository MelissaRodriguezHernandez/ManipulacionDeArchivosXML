package Paquete;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.IOException;

public class LeerXML {

    public static final String rutaFichero = "C:\\Users\\Mely\\IdeaProjects\\Matricula\\src\\Paquete\\CicleModulos.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        LeerXML_EventManager eventManager = new LeerXML_EventManager();

        //Le pasamos la ruta del XML y el objeto de la clase con el DefaultHandler y sus metodos
        saxParser.parse(rutaFichero, eventManager);


    }
}
