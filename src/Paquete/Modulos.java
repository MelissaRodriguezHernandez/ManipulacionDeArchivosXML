package Paquete;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Modulos {

    public static final String rutaFichero = "C:\\Users\\Mely\\IdeaProjects\\Matricula\\src\\Paquete\\CicleModulos.xml";

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory documentfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentfactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        document.setXmlVersion("1.1");

        Element root = document.createElement("cicle");
        document.appendChild(root);

        Attr atributo_cicle = document.createAttribute("codi");
        atributo_cicle.setValue("IFC32");
        root.setAttributeNode(atributo_cicle);

        Attr atributo_cicle1 = document.createAttribute("tipus");
        atributo_cicle1.setValue("CFGS");
        root.setAttributeNode(atributo_cicle1);

        Attr atributo_cicle2 = document.createAttribute("sigles");
        atributo_cicle2.setValue("DAM");
        root.setAttributeNode(atributo_cicle2);

        Attr atributo_cicle3 = document.createAttribute("nom");
        atributo_cicle3.setValue("Desenvolupament d'Aplicacions Multiplataforma");
        root.setAttributeNode(atributo_cicle);

        Element modul = document.createElement("modul");
        root.appendChild(modul);

        Attr atributo_modul = document.createAttribute("curs");
        atributo_modul.setValue("1");
        modul.setAttributeNode(atributo_modul);

        Attr atributo_modul1 = document.createAttribute("codi");
        atributo_modul1.setValue("0483");
        modul.setAttributeNode(atributo_modul1);

        Element nom = document.createElement("nom");
        nom.appendChild(document.createTextNode("Sistemes Informatics"));
        modul.appendChild(nom);

        Element nombreHores = document.createElement("nombreHores");
        nombreHores.appendChild(document.createTextNode("170"));
        modul.appendChild(nombreHores);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(rutaFichero));

        transformer.transform(domSource, streamResult);

        System.out.println("El fichero xml con los modulos se ha creado");

    }
}
