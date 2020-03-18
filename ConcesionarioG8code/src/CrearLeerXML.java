
import java.io.File;
import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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


public class CrearLeerXML {
	
	
	
	Scanner teclado = new Scanner(System.in);
	
    static Connection conexion = null;
    Statement comando = null;
    ResultSet registro;
    String nombreTabla;
    	    
    /**
	  * Conecta el objeto a la base de datos configurada en el método al crear un objeto ConexionBD
	  */ 
    public CrearLeerXML() {
    	try {
            //Driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");	 

        

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            conexion = null;
        } catch (SQLException ex) {
        	ex.printStackTrace();
            conexion = null;
        } catch (Exception ex) {
        	ex.printStackTrace();
        	conexion = null;
        }
    
	
	
          
        try {
            leerXML();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void leerXML() {
    	/*
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
            
            
             Coche c1 = new Coche();
     
            
            for(int i = 0 ; i < listavehiculo.getLength() ; i++) {
                Node nodo = listavehiculo.item(i);
                System.out.println("Elemento: " + nodo.getNodeName());
                
                Element element = (Element) nodo;
                
                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    
                	c1.setnBastidor(element.getElementsByTagName("Numero_bastidor").item(0).getTextContent());
                	c1.setMatricula(element.getElementsByTagName("Numero_bastidor").item(0).getTextContent());
                	c1.setColor(element.getElementsByTagName("Color").item(0).getTextContent());
                	//c1.setnAsientos(element.getElementsByTagName("Numero_asientos").item(0).getTextContent());
                	//c1.setPrecio(element.getElementsByTagName("Precio").item(0).getTextContent());
                	//c1.setnSerie(element.getElementsByTagName("Serie_Numero_serie").item(0).getTextContent());
                	c1.setTipo(element.getElementsByTagName("Tipo").item(0).getTextContent());
                	
                	
                	
                    System.out.println("Numero_bastidor: " + element.getElementsByTagName("Numero_bastidor").item(0).getTextContent());
                    System.out.println("Matricula: " + element.getElementsByTagName("Matricula").item(0).getTextContent());
                    System.out.println("Color: " + element.getElementsByTagName("Color").item(0).getTextContent());
                    System.out.println("Numero_asientos: " + element.getElementsByTagName("Numero_asientos").item(0).getNodeType());
                    System.out.println("Precio: " + element.getElementsByTagName("Precio").item(0).getTextContent());
                    System.out.println("Serie_Numero_serie: " + element.getElementsByTagName("Serie_Numero_serie").item(0).getTextContent());
                    System.out.println("Tipo: " + element.getElementsByTagName("Tipo").item(0).getTextContent());
                    
                    System.out.println("");
                }
                            
               
                   
            }
            
				}
				
		catch(Exception e) {
			e.printStackTrace(); 
        }
    
    	
    	
    */
    
    
    try {
        // Creo una instancia de DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Creo un documentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Creo un DOMImplementation
        DOMImplementation implementation = builder.getDOMImplementation();

        // Creo un documento con un elemento raiz
        Document documento = implementation.createDocument(null, "concesionario", null);
        documento.setXmlVersion("1.0");

        // Creo los elementos
        Element vehiculo = documento.createElement("vehiculo");
        
        // Numero_bastidor
        Element Numero_bastidor = documento.createElement("Numero_bastidor");
        Text textNumero_bastidor = documento.createTextNode("sdf13214");
        Numero_bastidor.appendChild(textNumero_bastidor);
        vehiculo.appendChild(Numero_bastidor);

        // Matricula
        Element matricula = documento.createElement("Matricula");
        Text textMatricula = documento.createTextNode("GRE1245");
        matricula.appendChild(textMatricula);
        vehiculo.appendChild(matricula);

        // Color
        Element color = documento.createElement("Color");
        Text textColor = documento.createTextNode("Verde");
        color.appendChild(textColor);
        vehiculo.appendChild(color);
        
        // Numero_asientos
        Element numero_asientos = documento.createElement("Numero_asientos");
        Text textNumero_asientos = documento.createTextNode("2");
        numero_asientos.appendChild(textNumero_asientos);
        vehiculo.appendChild(numero_asientos);

        // Precio
        Element precio = documento.createElement("Precio");
        Text textPrecio = documento.createTextNode("30000");
        precio.appendChild(textPrecio);
        vehiculo.appendChild(precio);
        
        // Numero_serie
        Element serie_numero_serie = documento.createElement("Serie_numero_serie");
        Text textSerie_numero_serie = documento.createTextNode("30000");
        serie_numero_serie.appendChild(textSerie_numero_serie);
        vehiculo.appendChild(serie_numero_serie);
        
        // Tipo
        Element tipo = documento.createElement("Tipo");
        Text textTipo = documento.createTextNode("coche");
        tipo.appendChild(textTipo);
        vehiculo.appendChild(tipo);


        // Añado al root el elemento vehiculo
        documento.getDocumentElement().appendChild(vehiculo);

        // Asocio el source con el Document
        Source source = new DOMSource(documento);
        // Creo el Result, indicado que fichero se va a crear
        Result result = new StreamResult(new File("concesionario.xml"));

        // Creo un transformer, se crea el fichero XML
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);

    } catch (ParserConfigurationException | TransformerException ex) {
        System.out.println(ex.getMessage());
    }
}
    
    
    





public static void main(String[] args) {
	
	CrearLeerXML ma = new CrearLeerXML();
	
	ma.leerXML();
	
	
	
	
	
}
}

