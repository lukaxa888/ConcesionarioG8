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
	     * Printea TODOS los datos de una tabla
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
	      * Método que inserta un valor introducido por teclado en la tabla definida"
	      */
	     public void insertarVehiculo(Vehiculo V1) {
	         
	    	 Coche C1=(Coche)V1;
	    	 Camion Cam1=(Camion)V1;
	    	 if(V1.getTipo()=="Coche") {
	    		 String Query = "INSERT INTO coche VALUES("+C1.getnPuertas()+","+C1.getCapacidadMaletero()+","+C1.getnBastidor()+")";
	    		 System.out.println("Se ha insertado un coche con "+C1.getnPuertas()+" puertas "+C1.getCapacidadMaletero()+ "de maletero y numero de bastidor "+C1.getnBastidor());
	    	 }
	    	 
	    	 if(V1.getTipo()=="Camion") {
	    		 String Query = "INSERT INTO coche VALUES("+Cam1.getCarga()+","+Cam1.getTipoMercancia()+","+Cam1.getnBastidor()+")";
	    		 System.out.println("Se ha insertado un camion con "+Cam1.getCarga()+" de carga, mercancía de tipo "+Cam1.getTipoMercancia()+" y numero de bastidor "+Cam1.getnBastidor());
	    	 }
	                try {
						Statement st = conexion.createStatement();
					} catch (SQLException e) {
						e.printStackTrace();
					}
	                java.sql.ResultSet resultado;
	    	 }
	    	 
	     
	     /**
		  * Conecta el objeto a la base de datos configurada en el método
		  */ 
	    public Connection MySQLConnect() {
	 
	        try {
	            //Driver JDBC
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conexion = DriverManager.getConnection("jdbc:mysql://10.14.0.96:3306/?user=root&password=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");	 
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
	        return conexion;
	    }
		        
	 public static void main(String[] args) {
		 //Scanner teclado = new Scanner(System.in);
		 ConexionBD db = new ConexionBD();
        db.MySQLConnect();

        
        
        db.verDatos("camion");
    
     }
	
}