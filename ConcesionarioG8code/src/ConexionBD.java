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

import com.mysql.cj.MysqlConnection;
	 
	public class ConexionBD {
	 
		Scanner teclado = new Scanner(System.in);
		
	    Connection conexion = null;
	    Statement comando = null;
	    ResultSet registro;
	    String nombreTabla;
	    	    
	    /**
		  * Conecta el objeto a la base de datos configurada en el método al crear un objeto ConexionBD.
		  */ 
	    public ConexionBD() {
	    	try {
	            //Driver JDBC
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");	 

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
	    }
	    
	    public void desconectarMYSQL() {
	    	try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    
	    /**
	     * Printea TODOS los datos de una tabla.
	     */
	     public void verDatos(String nombreTabla) {
	            try {	            
	            	
	            	String Query = "SELECT * FROM " + nombreTabla;
	                Statement st = conexion.createStatement();
	                java.sql.ResultSet resultado;
	                st.executeQuery("USE concesionario");
	                resultado = st.executeQuery(Query);         
	                
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
	    	 }
	    	 
	    	 if(V1.getTipo().equals("camion")) {
	    		 Camion Cam1=(Camion)V1;
	    		 Query = "INSERT IGNORE INTO vehiculo VALUES(\"" +Cam1.getnBastidor()+ "\",\"" +Cam1.getMatricula()+ "\",\"" +Cam1.getColor()+ "\","+Cam1.getnAsientos()+","+Cam1.getPrecio()+","+Cam1.getnSerie()+",\""+Cam1.getTipo()+"\")";
	    		 //System.out.println(Query);
	    		 Query2 = "INSERT IGNORE INTO camion VALUES("+Cam1.getCarga()+","+Cam1.getTipoMercancia()+ ",\"" +Cam1.getnBastidor()+"\")";
	    		 //System.out.println(Query2);
	    		 Query3 = "INSERT IGNORE INTO serie VALUES("+Cam1.getnSerie() + ",\"" + Cam1.getMarca()+ "\",\""+Cam1.getModelo()+"\","+Cam1.getAñoFabricacion()+")";
	    		 //System.out.println(Query3);
	    		 System.out.println("Se ha insertado un camion con "+Cam1.getCarga()+" de carga, mercancía "+Cam1.getTipoMercancia()+ " y numero de bastidor "+Cam1.getnBastidor());
	    	 }
	                try {
						Statement st = conexion.createStatement();
						st.executeQuery("USE concesionario");
						st.executeUpdate(Query);
						st.executeUpdate(Query3);
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
	     
	     
		        
	 public static void main(String[] args) {
		 ConexionBD db = new ConexionBD();
        
        db.verDatos("coche");
    
     }
	
}