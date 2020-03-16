public class Menu {

	CrearLeerXML xm1 = null;
	ConexionBD cbd = new ConexionBD();
	
	Menu(){
		
		
	}
	
	void menutexto() {
		
		System.out.println("\t GESTIÓN DE CONCESIONARIO G8");
		System.out.println("-----------------------------------------");
		
		System.out.println("¿Qué desea hacer?");
		
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
			
			if(numero == 1) {
				comprar();
			}
			
			if(numero == 2) {
				vender();
			}
			
			if(numero == 3) {
				pintar();
			}
			
			if(numero == 5) {
				salir=true;
			}
			
		}
	}
		
	void vender() {
		ConexionBD cbd = new ConexionBD();
		
		int numTipo;
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
		
	}	
	
	void pintar() {
		ConexionBD cbd = new ConexionBD();
		
		int numTipo;
		Coche c1=new Coche();
		Camion ca1=new Camion();		
		
		do {
			System.out.println("SISTEMA DE PINTADO");
			System.out.println("-------------------------------");
			System.out.println("Que desea pintar?");
			System.out.println("1-> COCHE");
			System.out.println("2-> CAMION");
			numTipo = Console.readInt();
		} while(numTipo<1||numTipo>2);
		
		System.out.println("Introduce un bastidor para pintar:");
		String numBastidor=Console.readString();
		
		System.out.println("Introduce un color nuevo para el vehículo:");
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
		
	}
	
	void comprar() {
		ConexionBD cbd = new ConexionBD();
	
		int numero;
		Coche c1=new Coche();
		Camion ca1=new Camion();
		int cocheOCamion;

		System.out.println("SISTEMA DE COMPRA");
		System.out.println("-------------------------------");
		System.out.println("Cómo desea introducir el vehículo?");
		
		do{
			System.out.println("1-> ARCHIVO XML");
			System.out.println("2-> INTRODUCIR DATOS A MANO");
			numero=Console.readInt();
			
		}while(numero<1||numero>2);
		
		if(numero==2) {
			
			do{
				System.out.println("1 Para coche");
				System.out.println("2 Para camión");
				System.out.println();
				
				cocheOCamion=Console.readInt();
				
			}while(cocheOCamion<1||cocheOCamion>2);
			
			if(cocheOCamion==1) {
				
				c1.setTipo("coche");
				
				System.out.println("Dame el numero de bastidor");
				c1.setnBastidor(Console.readString());
				System.out.println("Dame la matrícula");
				c1.setMatricula(Console.readString());
				System.out.println("Dame el color");
				c1.setColor(Console.readString());
				System.out.println("Dame el número de asientos");
				c1.setnAsientos(Console.readInt());
				System.out.println("¿Por cuanto has comprado el coche?");
				c1.setPrecio(Console.readInt());
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
			
				cbd.insertarVehiculo(c1);
			
				System.out.println();
				System.out.println("¡Has insertado un coche con exito!");
				System.out.println();
			
			}
			if(cocheOCamion==2) {
				
				ca1.setTipo("camion");
				
				System.out.println("Dame el numero de bastidor");
				ca1.setnBastidor(Console.readString());
				System.out.println("Dame la matrícula");
				ca1.setMatricula(Console.readString());
				System.out.println("Dame el color");
				ca1.setColor(Console.readString());
				System.out.println("Dame el número de asientos");
				ca1.setnAsientos(Console.readInt());
				System.out.println("¿Por cuanto has comprado el coche?");
				ca1.setPrecio(Console.readInt());
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
				
				cbd.insertarVehiculo(ca1);
				
				System.out.println();
				System.out.println("¡Has insertado un camión con exito!");
				System.out.println();
			
			}
			
		}
		
	}
	
	
	
}