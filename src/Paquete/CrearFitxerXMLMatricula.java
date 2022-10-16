package Paquete;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
//import java.io;

public class CrearFitxerXMLMatricula {

    public static final String rutaFichero = "C:\\Users\\Mely\\IdeaProjects\\Matricula\\src\\Paquete\\nomApellido.xml";

    public static void main(String[] args) {
        try{

            DocumentBuilderFactory documentfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentfactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            document.setXmlVersion("1.1");

            Element root = document.createElement("institut");
            document.appendChild(root);

            Element empleat = document.createElement("empleat");
            root.appendChild(empleat);

            Attr atributo_empleado = document.createAttribute("id");
            atributo_empleado.setValue("1");
            empleat.setAttributeNode(atributo_empleado);

//            Attr atributo_empleado2 = document.createAttribute("clase");
//            atributo_empleado2.setValue("1");
//            empleat.setAttributeNode(atributo_empleado2);

            Element nom = document.createElement("nom");
            nom.appendChild(document.createTextNode("Mely"));
            empleat.appendChild(nom);

            Element llinatge1 = document.createElement("llinatget1");
            llinatge1.appendChild(document.createTextNode("Rodriguez"));
            empleat.appendChild(llinatge1);

            Element llinatge2 = document.createElement("llinatge2");
            llinatge2.appendChild(document.createTextNode("Hernandez"));
            empleat.appendChild(llinatge2);

            Element telefono = document.createElement("telefon");
            telefono.appendChild(document.createTextNode("1234567"));
            empleat.appendChild(telefono);


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(rutaFichero));

            transformer.transform(domSource, streamResult);

            System.out.println("El fichero xml del empleado se ha creado");



        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
