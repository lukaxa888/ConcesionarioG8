import java.io.File;
import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.mysql.cj.MysqlConnection;
	 
	public class ConexionBD {
	 
		Scanner teclado = new Scanner(System.in);
		
	    private Connection conexion = null;
	    
	    /**
		  * Conecta el objeto a la base de datos configurada en el método al crear un objeto ConexionBD.
		  */ 
	    public ConexionBD() {
	    	try {
	            //Driver JDBC
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=mysql&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");	 	 

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
	    }

	    
	    public void desconectarMYSQL() {
	    	try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	   
	    
	    /**
	     * Printea TODOS los vehículos.
	     */
	     public void verDatosTotal() {
	    	 verDatosCoches();
	    	 System.out.println();
	    	 verDatosCamiones();
	     }
	     
	     /**
	      * Printea todos los coches
	      */
	     public void verDatosCoches() {
	    	 try {	            	            	
	            	String Query = "SELECT vehiculo.Numero_bastidor, vehiculo.Matricula, Vehiculo.Color, Vehiculo.Numero_asientos, Vehiculo.Precio, Vehiculo.Serie_Numero_serie, Coche.Numero_puertas, Coche.Capacidad_maletero FROM vehiculo inner join coche on vehiculo.Numero_bastidor = coche.Vehiculo_Numero_bastidor;";
	                Statement st = conexion.createStatement();	                
	                st.executeQuery("USE concesionario");
	                java.sql.ResultSet resultado = st.executeQuery(Query);              
	                
	                for (int x=1;x<=resultado.getMetaData().getColumnCount();x++) {
            	     	System.out.print(resultado.getMetaData().getColumnName(x)+ "\t");        
	                }
            	 
            	System.out.println();
            	
	                while(resultado.next()) {
	                	   for (int x=1;x<=resultado.getMetaData().getColumnCount();x++)
	                		   System.out.print(resultado.getString(x)+ "\t");                	   
	                	   	   System.out.println("");
	                } 
	            
	            } catch (SQLException ex) {
	            	ex.printStackTrace();
	            }
	     }
	     
	     /**
	      * Printea todos los camiones
	      */
	     public void verDatosCamiones() {
	    	 try {	            	            	
	            	String Query = "SELECT vehiculo.Numero_bastidor, vehiculo.Matricula, Vehiculo.Color, Vehiculo.Numero_asientos, Vehiculo.Precio, Vehiculo.Serie_Numero_serie, Camion.Tipo_mercancia, Camion.Carga FROM vehiculo inner join camion on vehiculo.Numero_bastidor = camion.Vehiculo_Numero_bastidor;";
	                Statement st = conexion.createStatement();
	                st.executeQuery("USE concesionario");
	                java.sql.ResultSet resultado = st.executeQuery(Query);                
 
	                for (int x=1;x<=resultado.getMetaData().getColumnCount();x++) {
            	     	System.out.print(resultado.getMetaData().getColumnName(x)+ "\t");        
	                }
            	 
            	System.out.println();
            	
	                while(resultado.next()) {
	                	   for (int x=1;x<=resultado.getMetaData().getColumnCount();x++)
	                		   System.out.print(resultado.getString(x)+ "\t");                	   
	                	   	   System.out.println("");
	                } 
	            
	            } catch (SQLException ex) {
	            	ex.printStackTrace();
	            }
	     }
	     
	     
	     /**
	      * Método que inserta un valor introducido por teclado en la tabla definida.
	      */
	     public void insertarVehiculo(Vehiculo V1) {
	    	 String Query = new String();
	    	 String Query2 = new String();
	    	 String Query3 = new String();
	    	 
	    	 if(V1.getTipo().equals("coche")) {
	    		 Coche C1=(Coche)V1;	    		 
	    		 Query = "INSERT IGNORE INTO vehiculo VALUES(\"" +C1.getnBastidor()+ "\",\"" +C1.getMatricula()+ "\",\"" +C1.getColor()+ "\","+C1.getnAsientos()+","+C1.getPrecio()+","+C1.getnSerie()+",\""+C1.getTipo()+"\")";
	    		 //System.out.println(Query);
	    		 Query2 = "INSERT IGNORE INTO coche VALUES("+C1.getnPuertas()+","+C1.getCapacidadMaletero()+ ",\"" +C1.getnBastidor()+"\")";
	    		 //System.out.println(Query2);
	    		 Query3 = "INSERT IGNORE INTO serie VALUES("+C1.getnSerie() + ",\"" + C1.getMarca()+ "\",\""+C1.getModelo()+"\","+C1.getAñoFabricacion()+")";
	    		 //System.out.println(Query3);
	    		 
	    		 //INSERT IGNORE sirve para que si existe un valor igual no te haga insert. Si no existe si que te lo inserta.
	    		 System.out.println("Se ha insertado un coche con "+C1.getnPuertas()+" puertas "+C1.getCapacidadMaletero()+ " de maletero y numero de bastidor "+C1.getnBastidor());
	    		 System.out.println();
	    	 }
	    	 
	    	 if(V1.getTipo().equals("camion")) {
	    		 Camion Cam1=(Camion)V1;
	    		 Query = "INSERT IGNORE INTO vehiculo VALUES(\"" +Cam1.getnBastidor()+ "\",\"" +Cam1.getMatricula()+ "\",\"" +Cam1.getColor()+ "\","+Cam1.getnAsientos()+","+Cam1.getPrecio()+","+Cam1.getnSerie()+",\""+Cam1.getTipo()+"\")";
	    		 //System.out.println(Query);
	    		 Query2 = "INSERT IGNORE INTO camion VALUES("+Cam1.getCarga()+",\""+Cam1.getTipoMercancia()+ "\",\"" +Cam1.getnBastidor()+"\")";
	    		 //System.out.println(Query2);
	    		 Query3 = "INSERT IGNORE INTO serie VALUES("+Cam1.getnSerie() + ",\"" + Cam1.getMarca()+ "\",\""+Cam1.getModelo()+"\","+Cam1.getAñoFabricacion()+")";
	    		 //System.out.println(Query3);
	    		 System.out.println("Se ha insertado un camion con "+Cam1.getCarga()+" de carga, mercancía "+Cam1.getTipoMercancia()+ " y numero de bastidor "+Cam1.getnBastidor());
	    		 System.out.println();
	    	 }
	                try {
						Statement st = conexion.createStatement();
						st.executeQuery("USE concesionario");
						st.executeUpdate(Query3);
						st.executeUpdate(Query);
						st.executeUpdate(Query2);
					} catch (SQLException e) {
						e.printStackTrace();
					}
	    	 }
	    
	     
	     /**
	      * Elimina el registro del vehículo que se le pasa por parámetros.
	      */
	     public void venderVehiculo(String numeroBastidor) {
	    	    	 
	    	 String Query = new String();
	    	 String Query1 = new String();
	    	 String Query2 = new String();
	    	 
	    	 
	    		 Query = "DELETE FROM vehiculo WHERE Numero_bastidor=\""+numeroBastidor+"\"";
	    		 //System.out.println(Query);
	    		 Query1 = "DELETE FROM coche WHERE Vehiculo_Numero_bastidor=\""+numeroBastidor+"\"";
	    		 //System.out.println(Query1);    		 
	    		 Query2 = "DELETE FROM camion WHERE Vehiculo_Numero_bastidor=\""+numeroBastidor+"\"";
	    		 //System.out.println(Query2);
	    		 System.out.println("Correcto. Se ha eliminado el vehiculo con numero de bastidor "+numeroBastidor+".");
	    		 System.out.println();
	    	 
	                try {
						Statement st = conexion.createStatement();
						st.executeQuery("USE concesionario");
						st.executeUpdate(Query);
						st.executeUpdate(Query1);
						st.executeUpdate(Query2);
					} catch (SQLException e) {
						e.printStackTrace();
					}
	     }	     
	
	     
	     /**
	      * Pide por parametros un numero de bastidor y un color y le asigna ese color al vehículo al que le corresponde el número
	      */
	     public void pintarVehiculo(String numeroBastidor, String nuevoColor) {
	    	 
	    	 String Query = new String();
	    	 
	    		 Query = "UPDATE vehiculo SET Color=\""+nuevoColor+"\" WHERE Numero_bastidor=\""+numeroBastidor+"\"";
	    		 //System.out.println(Query);	    		 
	    		 System.out.println("Correcto. Se ha pintado de color "+nuevoColor+" el vehiculo con numero de bastidor "+numeroBastidor+".");
	    		 System.out.println();
	    	 
	                try {
						Statement st = conexion.createStatement();
						st.executeQuery("USE concesionario");
						st.executeUpdate(Query);
					} catch (SQLException e) {
						e.printStackTrace();
					}
	     }

	     
	     /**
	      * Llama al procedimiento de la base de datos que lista todos los vehículos pintados del color que se le pasa
	      */
	     public void vehiculosPintados(String color) {
	    	 String Query = new String();
	    	 
	    	 Query = "call concesionario.Color_Coche('"+color+"');";
	    	 //System.out.println(Query);
	    	 
	    	 	try {
	    	 		 Statement st = conexion.createStatement();
		             java.sql.ResultSet resultado;
		             st.executeQuery("USE concesionario");
		             resultado = st.executeQuery(Query);
		                
		             for (int x=1;x<=resultado.getMetaData().getColumnCount();x++) {
		           	     System.out.print(resultado.getMetaData().getColumnName(x)+ "\t");        
		             }
		             
		             System.out.println();
		             
		             while(resultado.next()) {
		                for (int x=1;x<=resultado.getMetaData().getColumnCount();x++) {
		                	System.out.print(resultado.getString(x)+ "\t");		                	   
		                	System.out.print("");
		                }
		                System.out.println();
		             }
				
	    	 	} catch (SQLException e) {
					e.printStackTrace();
				}
	    	 	System.out.println();	
 	 	
	     }
  
	     
	     /**
	      * Exporta los datos de la base de datos a un archivo xml
	      */
	     public void verDatosXML(String nombreTabla) {
	            try {	            
	            	
	            	String Query = "SELECT * FROM " + nombreTabla;
	                Statement st = conexion.createStatement();
	                java.sql.ResultSet resultado;
	                st.executeQuery("USE concesionario");
	                resultado = st.executeQuery(Query);         
	                    	        		     	                		   
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
	                		        
	                		        while(resultado.next()) {
                		        
	                		        	// Creo los elementos
	                		        	Element vehiculo = documento.createElement("vehiculo");
	                		        
	                		        	// Numero_bastidor
	                		        	Element Numero_bastidor = documento.createElement("Numero_bastidor");
	                		        	Text textNumero_bastidor = documento.createTextNode(resultado.getString("Numero_bastidor"));
	                		        	Numero_bastidor.appendChild(textNumero_bastidor);
	                		        	vehiculo.appendChild(Numero_bastidor);

	                		        	// Matricula
	                		        	Element matricula = documento.createElement("Matricula");
	                		        	Text textMatricula = documento.createTextNode(resultado.getString("Matricula"));
	                		        	matricula.appendChild(textMatricula);
	                		        	vehiculo.appendChild(matricula);

	                		        	// Color
	                		        	Element color = documento.createElement("Color");
	                		        	Text textColor = documento.createTextNode(resultado.getString("Color"));
	                		        	color.appendChild(textColor);
	                		        	vehiculo.appendChild(color);
	                		        
	                		        	// Numero_asientos
	                		        	Element numero_asientos = documento.createElement("Numero_asientos");
	                		        	Text textNumero_asientos = documento.createTextNode(resultado.getString("Numero_asientos"));
	                		        	numero_asientos.appendChild(textNumero_asientos);
	                		        	vehiculo.appendChild(numero_asientos);

	                		        	// Precio
	                		        	Element precio = documento.createElement("Precio");
	                		        	Text textPrecio = documento.createTextNode(resultado.getString("Precio"));
	                		        	precio.appendChild(textPrecio);
	                		        	vehiculo.appendChild(precio);
	                		        
	                		        	// Numero_serie
	                		        	Element serie_numero_serie = documento.createElement("Serie_numero_serie");
	                		        	Text textSerie_numero_serie = documento.createTextNode(resultado.getString("Serie_numero_serie"));
	                		        	serie_numero_serie.appendChild(textSerie_numero_serie);
	                		        	vehiculo.appendChild(serie_numero_serie);
	                		        
		                		        // Tipo
		                		        Element tipo = documento.createElement("Tipo");
		                		        Text textTipo = documento.createTextNode(resultado.getString("Tipo"));
		                		        tipo.appendChild(textTipo);
		                		        vehiculo.appendChild(tipo);           		        
	                		        
		                		        // Añado al root el elemento vehiculo
		                		        documento.getDocumentElement().appendChild(vehiculo);
	                		        
	                		        }
		                			   
	                		        // Asocio el source con el Document
	                		        Source source = new DOMSource(documento);
	                		        // Creo el Result, indicado que fichero se va a crear
	                		        
	                		        Result result = new StreamResult(new File("Concesionario.xml"));

	                		        // Creo un transformer, se crea el fichero XML
	                		        Transformer transformer = TransformerFactory.newInstance().newTransformer();
	                		        transformer.transform(source, result);
	        	                	 
	                		    } catch (ParserConfigurationException | TransformerException ex) {
	                		        System.out.println(ex.getMessage());
	                		    }
	               	   
	                	   System.out.println("");                 
	            
	            } catch (SQLException ex) {
	            	ex.printStackTrace();
	            }
	        }
	
}