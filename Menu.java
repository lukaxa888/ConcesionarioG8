package Concesionario;

public class Menu {

	
	Menu(){
		
		
	}
	
	void menutexto() {
		System.out.println("�Qu� quieres hacer?");
		
		System.out.println("1 \t Comprar");
		
		System.out.println("2 \t Vender");
		
		System.out.println("3 \t Pintar");
		
		System.out.println("4 \t Inventario");
		
		System.out.println("5 \t Salir");
		
	}
	
	void menu() {
		boolean salir=false;
		int numero;
		
		
		while(salir==false) {
			do {
			menutexto();
			System.out.println();
			numero =  Console.readInt();
			if(numero < 1 || numero > 5 ) {
				System.out.println("Intenta un numero entre 1 y 5");
			}
			System.out.println();
			}while(numero < 0 && numero > 6);
			
			if(numero == 5) {
				salir=true;
			}
			
		}
		
		
		
	}
	
	void comprar() {
		int numero;
		int cocheOCamion;
		int nBastidor;
		int matricula;
		String color;
		int nAsientos;
		int precio;
		String tipo;
		int nSerie;
		String modelo;
		String marca;
		int a�oFabricacion;
		do{
			
			numero=Console.readInt();
			
		}while(numero<1||numero>2);
		
		if(numero==2) {
			
			
			do{
				System.out.println("1 Para coche");
				
				System.out.println("2 Para cami�n");
				
				cocheOCamion=Console.readInt();
				
			}while(cocheOCamion<1||cocheOCamion>2);
			if(cocheOCamion==1) {
				Coche c1=new Coche();
				ConexionBD cbd = new ConexionBD();
				
				System.out.println("Dame el numero de bastidor");
				c1.setA�oFabricacion(Console.readInt());
				System.out.println("Dame la matr�cula");
				c1.setMatricula(Console.readString());
				System.out.println("Dame el color");
				c1.setColor(Console.readString());
				System.out.println("Dame el n�mero de asientos");
				c1.setnAsientos(Console.readInt());
				System.out.println("�Por cuanto has comprado el coche?");
				c1.setPrecio(Console.readInt());
				tipo="Coche";
				System.out.println("Dame el n�mero de s�rie");
				c1.setnSerie(Console.readInt());
				System.out.println("Dame el modelo");
				c1.setModelo(Console.readString());
				System.out.println("Dame la marca");
				c1.setMarca(Console.readString());
				System.out.println("Dame el a�o de fabricaci�n");

				c1.setA�oFabricacion(Console.readInt());
				System.out.println("Dame el n�mero de puertas");
				c1.setnPuertas(Console.readInt());
				System.out.println("�C�al es la capacidad del maletero?");
				c1.setCapacidadMaletero(Console.readInt());

				a�oFabricacion = Console.readInt();
				
				
				cbd.insertarVehiculo(c1);
				
			

				
				System.out.println();
				System.out.println();
				System.out.println("�Has insertado un coche con exito!");
			
			
			}
			if(cocheOCamion==2) {
				Camion ca1=new Camion();
				
				
				System.out.println("Dame el numero de bastidor");
				ca1.setA�oFabricacion(Console.readInt());
				System.out.println("Dame la matr�cula");
				ca1.setMatricula(Console.readString());
				System.out.println("Dame el color");
				ca1.setColor(Console.readString());
				System.out.println("Dame el n�mero de asientos");
				ca1.setnAsientos(Console.readInt());
				System.out.println("�Por cuanto has comprado el coche?");
				ca1.setPrecio(Console.readInt());
				tipo="Coche";
				System.out.println("Dame el n�mero de s�rie");
				ca1.setnSerie(Console.readInt());
				System.out.println("Dame el modelo");
				ca1.setModelo(Console.readString());
				System.out.println("Dame la marca");
				ca1.setMarca(Console.readString());
				System.out.println("Dame el a�o de fabricaci�n");
				ca1.setA�oFabricacion(Console.readInt());
				System.out.println("�C�al es la capacidad maxima de la carga");
				ca1.setCarga(Console.readInt());
				System.out.println("�C�al es el tipo de mercanc�a?");
				ca1.setTipoMercancia(Console.readString());;
				
				System.out.println();
				System.out.println();
				System.out.println("�Has insertado un cami�n con exito!");
			
			
			}
			
		}
		
		
		
	}
	
	
	
}
