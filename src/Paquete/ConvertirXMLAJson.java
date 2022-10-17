package Paquete;


import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertirXMLAJson {

    public static final String rutaFichero = "C:\\Users\\Mely\\IdeaProjects\\Matricula\\src\\Paquete\\CicleModulos.xml";
    public static final int INDENTACION = 4;

    public static void main(String[] args) throws IOException {

        String strfitxerXML = new String(Files.readAllBytes(Paths.get(rutaFichero)));
        //System.out.println(strfitxerXML);

        JSONObject obJson = XML.toJSONObject(strfitxerXML);

        String strfitxerJson = obJson.toString(INDENTACION);

        System.out.println(strfitxerJson);

    }
}
