package Concesionario;

public class Menu {

	
	Menu(){
		
		
	}
	
	void menutexto() {
		System.out.println("¿Qué quieres hacer?");
		
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
		int añoFabricacion;
		do{
			
			numero=Console.readInt();
			
		}while(numero<1||numero>2);
		
		if(numero==2) {
			
			
			do{
				System.out.println("1 Para coche");
				
				System.out.println("2 Para camión");
				
				cocheOCamion=Console.readInt();
				
			}while(cocheOCamion<1||cocheOCamion>2);
			if(cocheOCamion==1) {
				Coche c1=new Coche();
				ConexionBD cbd = new ConexionBD();
				
				System.out.println("Dame el numero de bastidor");
				c1.setAñoFabricacion(Console.readInt());
				System.out.println("Dame la matrícula");
				c1.setMatricula(Console.readString());
				System.out.println("Dame el color");
				c1.setColor(Console.readString());
				System.out.println("Dame el número de asientos");
				c1.setnAsientos(Console.readInt());
				System.out.println("¿Por cuanto has comprado el coche?");
				c1.setPrecio(Console.readInt());
				tipo="Coche";
				System.out.println("Dame el número de série");
				c1.setnSerie(Console.readInt());
				System.out.println("Dame el modelo");
				c1.setModelo(Console.readString());
				System.out.println("Dame la marca");
				c1.setMarca(Console.readString());
				System.out.println("Dame el año de fabricación");

				c1.setAñoFabricacion(Console.readInt());
				System.out.println("Dame el número de puertas");
				c1.setnPuertas(Console.readInt());
				System.out.println("¿Cúal es la capacidad del maletero?");
				c1.setCapacidadMaletero(Console.readInt());

				añoFabricacion = Console.readInt();
				
				
				cbd.insertarVehiculo(c1);
				
			

				
				System.out.println();
				System.out.println();
				System.out.println("¿Has insertado un coche con exito!");
			
			
			}
			if(cocheOCamion==2) {
				Camion ca1=new Camion();
				
				
				System.out.println("Dame el numero de bastidor");
				ca1.setAñoFabricacion(Console.readInt());
				System.out.println("Dame la matrícula");
				ca1.setMatricula(Console.readString());
				System.out.println("Dame el color");
				ca1.setColor(Console.readString());
				System.out.println("Dame el número de asientos");
				ca1.setnAsientos(Console.readInt());
				System.out.println("¿Por cuanto has comprado el coche?");
				ca1.setPrecio(Console.readInt());
				tipo="Coche";
				System.out.println("Dame el número de série");
				ca1.setnSerie(Console.readInt());
				System.out.println("Dame el modelo");
				ca1.setModelo(Console.readString());
				System.out.println("Dame la marca");
				ca1.setMarca(Console.readString());
				System.out.println("Dame el año de fabricación");
				ca1.setAñoFabricacion(Console.readInt());
				System.out.println("¿Cúal es la capacidad maxima de la carga");
				ca1.setCarga(Console.readInt());
				System.out.println("¿Cúal es el tipo de mercancía?");
				ca1.setTipoMercancia(Console.readString());;
				
				System.out.println();
				System.out.println();
				System.out.println("¿Has insertado un camión con exito!");
			
			
			}
			
		}
		
		
		
	}
	
	
	
}
