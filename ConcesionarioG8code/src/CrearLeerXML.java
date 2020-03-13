

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


/**
 *
 * @author xcheko51x
 */
public class CrearLeerXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nomArchivo = "Concesionario";
        
        List<vehiculo_xml> listaUsuarios = new ArrayList<vehiculo_xml>();
        
        listaUsuarios.add(new vehiculo_xml(1, "Sergio", "234242543543"));
        listaUsuarios.add(new vehiculo_xml(2, "Laura", "76865542424"));
        
        try {
            crearXML(nomArchivo, listaUsuarios);
            leerXML();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void leerXML() {
    	
    	try {
            System.out.println("Introduce nombre de XML (SIN EXTENSIÓN):");
            String nombrexml = Console.readString();
            File archivo = new File(nombrexml+".xml");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            
            document.getDocumentElement().normalize();
            
            System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());
            
            NodeList listavehiculo = document.getElementsByTagName("vehiculo");
            
            for(int i = 0 ; i < listavehiculo.getLength() ; i++) {
                Node nodo = listavehiculo.item(i);
                System.out.println("Elemento: " + nodo.getNodeName());
                
                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("Numero_bastidor: " + element.getElementsByTagName("Numero_bastidor").item(0).getTextContent());
                    System.out.println("Matricula: " + element.getElementsByTagName("Matricula").item(0).getTextContent());
                    System.out.println("Color: " + element.getElementsByTagName("Color").item(0).getTextContent());
                    System.out.println("Numero_asientos: " + element.getElementsByTagName("Numero_asientos").item(0).getTextContent());
                    System.out.println("Precio: " + element.getElementsByTagName("Precio").item(0).getTextContent());
                    System.out.println("Serioe_Numero_serie: " + element.getElementsByTagName("Serioe_Numero_serie").item(0).getTextContent());
                    System.out.println("Tipo: " + element.getElementsByTagName("Tipo").item(0).getTextContent());
                    
                    System.out.println("");
                }
            }
            
        } catch(Exception e) {
           System.out.println();
        	System.out.println("No se encuentra el archivo, saliendo al menú...");
           System.out.println();
        	// e.printStackTrace();   
        }
 	
    }
    
    public static void crearXML(String nomArchivo, List<vehiculo_xml> listaUsuarios) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, nomArchivo, null);
            document.setXmlVersion("1.0");
            
            // NODO RAIZ
            Element raiz = document.getDocumentElement();
            
            for(int i = 0 ; i <listaUsuarios.size() ; i++) {
                Element itemNode = document.createElement("USUARIO");
                
                Element idNode = document.createElement("ID");
                Text nodeIdValue =document.createTextNode("" +  listaUsuarios.get(i).getIdUsuario());
                idNode.appendChild(nodeIdValue);
                
                Element nombreNode = document.createElement("NOMBRE");
                Text nodeNombreValue =document.createTextNode(listaUsuarios.get(i).getNombre());
                nombreNode.appendChild(nodeNombreValue);
                
                Element telefonoNode = document.createElement("TELEFONO");
                Text nodeTelefonoValue =document.createTextNode(listaUsuarios.get(i).getTelefono());
                telefonoNode.appendChild(nodeTelefonoValue);
                
                itemNode.appendChild(idNode);
                itemNode.appendChild(nombreNode);
                itemNode.appendChild(telefonoNode);
                
                raiz.appendChild(itemNode);
            }
            
            // GENERA XML
            Source source = new DOMSource(document);
            
            // DONDE SE GUARDARA
            Result result = new StreamResult(new java.io.File(nomArchivo + ".xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        
        } catch(ParserConfigurationException e) {
            
        }
    }
    
}
