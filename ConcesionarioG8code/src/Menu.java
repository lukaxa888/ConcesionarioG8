import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Menu {

	CrearLeerXML xm1 = null;
	ConexionBD cbd = new ConexionBD();
	
	Menu(){
		
		
	}
	
	public void Correcionnumeros() throws NumberFormatException {
		System.out.println("Introduce numeros, no eso");
	}
	
	void menutexto() {
		
		System.out.println("\t GESTI�N DE CONCESIONARIO G8");
		System.out.println("-----------------------------------------");
		
		System.out.println("�Qu� desea hacer?");
		
		System.out.println("1 \t Comprar");
		
		System.out.println("2 \t Vender");
		
		System.out.println("3 \t Pintar");
		
		System.out.println("4 \t Stock de Veh�culos");
		
		System.out.println("5 \t Salir");
		
	}
	
	void menu() {
		boolean salir=false;
		int numero = 0;
		
		while(salir==false) {
			do {
				menutexto();
				System.out.print("Introduzca una opci�n: ");
				numero =  Console.readInt();
				
				if(numero < 1 || numero > 5 ) {
					System.out.println("Error. Se debe introducir un n�mero entre 1 y 5");
				}
					System.out.println();
				
			} while(numero < 0 && numero > 6);
			
			if(numero == 1) {
				comprar();
			}
			
			if(numero == 2) {
				vender();
			}
			
			if(numero == 3) {
				pintar();
			}
			
			if(numero == 4) {
				stock();
			}
			
			if(numero == 5) {
				salir=true;
			}
			
		}
	}
		
	/**
	 * Pide un tipo de veh�culo y lista todos los que hay junto con sus atributos.
	 */
	void stock() {
		ConexionBD cbd = new ConexionBD();
		
		int numTipo = 0;
		
		do {
			System.out.println("VEH�CULOS EN STOCK");
			System.out.println("-------------------------------");
			System.out.println("Que desea listar?");
			System.out.println("1-> COCHES");
			System.out.println("2-> CAMIONES");
			numTipo = Console.readInt();
		} while(numTipo<1||numTipo>2);
		
		if(numTipo==1) {
			cbd.verDatos("coche");
			System.out.println();
		}
		
		if(numTipo==2) {
			cbd.verDatos("camion");
			System.out.println();
		}
		
		cbd.desconectarMYSQL();
	}	
	
	void vender() {
		ConexionBD cbd = new ConexionBD();
		
		int numTipo = 0;
		Coche c1=new Coche();
		Camion ca1=new Camion();		
		
		do {
			System.out.println("SISTEMA DE VENTA");
			System.out.println("-------------------------------");
			System.out.println("Que desea vender?");
			System.out.println("1-> COCHE");
			System.out.println("2-> CAMION");
			numTipo = Console.readInt();				
		} while(numTipo<1||numTipo>2);
		
		System.out.println("Introduce un bastidor para borrar:");
		String numBastidor=Console.readString();
		
		if(numTipo==1) {
			c1.setnBastidor(numBastidor);
			cbd.venderVehiculo(c1.getnBastidor());
		}
		
		if(numTipo==2) {
			ca1.setnBastidor(numBastidor);
			cbd.venderVehiculo(ca1.getnBastidor());
		}
		cbd.desconectarMYSQL();
	}	
	
	void pintar() {
		ConexionBD cbd = new ConexionBD();
		
		int numTipo = 0;
		Coche c1=new Coche();
		Camion ca1=new Camion();	

		do {		
			System.out.println("SISTEMA DE PINTADO");
			System.out.println("-------------------------------------------");
			System.out.println("Que desea pintar?");
			System.out.println("1-> COCHE");
			System.out.println("2-> CAMION");			
			numTipo = Console.readInt();			
		} while(numTipo<1||numTipo>2);
		
		System.out.println("Introduce un bastidor para pintar:");
		String numBastidor=Console.readString();
		
		System.out.println("Introduce un color nuevo para el veh�culo:");
		String nuevoColor=Console.readString();
		
		if(numTipo==1) {
			c1.setnBastidor(numBastidor);
			c1.setColor(nuevoColor);
			cbd.pintarVehiculo(c1.getnBastidor(),c1.getColor());
		}
		
		if(numTipo==2) {
			ca1.setnBastidor(numBastidor);
			ca1.setColor(nuevoColor);
			cbd.pintarVehiculo(ca1.getnBastidor(),ca1.getColor());
		}
		
		
		cbd.desconectarMYSQL();
	}
	
	void comprar() {
		ConexionBD cbd = new ConexionBD();
	
		int numero = 0;

		Coche c1=new Coche();
		Camion ca1=new Camion();
		int cocheOCamion = 0;

		System.out.println("SISTEMA DE COMPRA");
		System.out.println("-------------------------------");
		System.out.println("C�mo desea introducir el veh�culo?");
		
		do{
			System.out.println("1-> ARCHIVO XML");
			System.out.println("2-> INTRODUCIR DATOS A MANO");
			numero=Console.readInt();
		} while(numero<1||numero>2);
		
		if(numero==1) {
			
			try {
	            System.out.println("Introduce nombre de XML (SIN EXTENSI�N):");
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
	                
	                Element element = (Element) nodo;
	                
	                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
	                    
	                	c1.setnBastidor(element.getElementsByTagName("Numero_bastidor").item(0).getTextContent());
	                	c1.setMatricula(element.getElementsByTagName("Matricula").item(0).getTextContent());
	                	c1.setColor(element.getElementsByTagName("Color").item(0).getTextContent());
	                	c1.setnAsientos(element.getElementsByTagName("Numero_asientos").item(0).getNodeType());
	                	c1.setPrecio(element.getElementsByTagName("Precio").item(0).getNodeType());
	                	c1.setnSerie(element.getElementsByTagName("Serie_Numero_serie").item(0).getNodeType());
	                	c1.setTipo(element.getElementsByTagName("Tipo").item(0).getTextContent());
	                	
	                    System.out.println("Numero_bastidor: " + element.getElementsByTagName("Numero_bastidor").item(0).getTextContent());
	                    System.out.println("Matricula: " + element.getElementsByTagName("Matricula").item(0).getTextContent());
	                    System.out.println("Color: " + element.getElementsByTagName("Color").item(0).getTextContent());
	                    System.out.println("Numero_asientos: " + element.getElementsByTagName("Numero_asientos").item(0).getTextContent());
	                    System.out.println("Precio: " + element.getElementsByTagName("Precio").item(0).getTextContent());
	                    System.out.println("Serie_Numero_serie: " + element.getElementsByTagName("Serie_Numero_serie").item(0).getTextContent());
	                    System.out.println("Tipo: " + element.getElementsByTagName("Tipo").item(0).getTextContent());
	                    
	                    System.out.println("");
	                    
	                    cbd.insertarVehiculo(c1);
	                }
	                   
	            }
	            
				}
					
			catch(Exception e) {
				e.printStackTrace(); 
	        }
			
		}
		
		
		if(numero==2) {
			
			do{
				System.out.println("1 Para coche");
				System.out.println("2 Para cami�n");
				System.out.println();
				
					cocheOCamion=Console.readInt();
				
			} while(cocheOCamion<1||cocheOCamion>2);
			
			if(cocheOCamion==1) {
				
				c1.setTipo("coche");
				
				System.out.println("Numero de bastidor:");
					c1.setnBastidor(Console.readString());
			
				System.out.println("Matr�cula:");
					c1.setMatricula(Console.readString());
				
				System.out.println("Color:");
					c1.setColor(Console.readString());
				
				System.out.println("N�mero de asientos:");
					c1.setnAsientos(Console.readInt());
					
				System.out.println("Precio pagado:");
					c1.setPrecio(Console.readInt());
				
				System.out.println("N�mero de serie:");
					c1.setnSerie(Console.readInt());
				
				System.out.println("Marca:");
					c1.setMarca(Console.readString());
				
				System.out.println("Modelo:");
					c1.setModelo(Console.readString());
				
				System.out.println("A�o de fabricaci�n:");
					c1.setA�oFabricacion(Console.readInt());
				
				System.out.println("N�mero de puertas:");
					c1.setnPuertas(Console.readInt());
				
				System.out.println("Capacidad de maletero:");
					c1.setCapacidadMaletero(Console.readInt());
			
				cbd.insertarVehiculo(c1);
			
			}
			
			if(cocheOCamion==2) {
				
				ca1.setTipo("camion");
				
				System.out.println("Numero de bastidor:");
					ca1.setnBastidor(Console.readString());
					
				System.out.println("Matr�cula:");
					ca1.setMatricula(Console.readString());
					
				System.out.println("Color:");
					ca1.setColor(Console.readString());
					
				System.out.println("N�mero de asientos:");
					ca1.setnAsientos(Console.readInt());
					
				System.out.println("Precio pagado:");
					ca1.setPrecio(Console.readInt());
					
				System.out.println("N�mero de s�rie:");
					ca1.setnSerie(Console.readInt());
					
				System.out.println("Marca:");
					ca1.setMarca(Console.readString());
				
				System.out.println("Modelo:");
					ca1.setModelo(Console.readString());
				
				System.out.println("A�o de fabricaci�n:");
					ca1.setA�oFabricacion(Console.readInt());
					
				System.out.println("Capacidad m�x. de carga:");
					ca1.setCarga(Console.readInt());
					
				System.out.println("Tipo de mercanc�a:");
					ca1.setTipoMercancia(Console.readString());
				
				cbd.insertarVehiculo(ca1);
			
			}
			
		}
		cbd.desconectarMYSQL();
	}
	
	
	
}


