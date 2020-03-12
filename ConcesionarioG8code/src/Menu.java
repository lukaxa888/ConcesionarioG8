public class Menu {

	CrearLeerXML xm1 = null;
	
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
			if(numero == 1) {
				comprar();
			}
			if(numero == 5) {
				salir=true;
			}
			
		}
	}
		
		
	
	void comprar() {
		ConexionBD cbd = new ConexionBD();
	
		int numero;
		Coche c1=new Coche();
		Camion ca1=new Camion();
		int cocheOCamion;
		String nBastidor;
		String matricula;
		String color;
		int nAsientos;
		int precio;
		String tipo;
		int nSerie;
		String modelo;
		String marca;
		int añoFabricacion;
		do{
			System.out.println("1 Para XML");
			System.out.println("2 Para a mano");
			numero=Console.readInt();
			
		}while(numero<1||numero>2);
		
		if(numero==2) {
			
			
			do{
				System.out.println("1 Para coche");
				
				System.out.println("2 Para camión");
				
				cocheOCamion=Console.readInt();
				
			}while(cocheOCamion<1||cocheOCamion>2);
			System.out.println("Dame el numero de bastidor");
			nBastidor = Console.readString();
			System.out.println("Dame la matrícula");
			matricula = Console.readString();
			System.out.println("Dame el color");
			color = Console.readString();
			System.out.println("Dame el número de asientos");
			nAsientos = Console.readInt();
			System.out.println("¿Por cuanto has comprado el coche?");
			precio = Console.readInt();
			
			System.out.println("Dame el número de série");
			nSerie = Console.readInt();
			System.out.println("Dame el modelo");
			modelo =  Console.readString();
			System.out.println("Dame la marca");
			marca = Console.readString();
			System.out.println("Dame el año de fabricación");
			añoFabricacion =  Console.readInt();
			if(cocheOCamion==1) {
				c1.setTipo("Coche");
				c1.setnBastidor(nBastidor);
				c1.setMatricula(matricula);
				c1.setColor(color);
				c1.setnAsientos(nAsientos);
				c1.setPrecio(precio);
				c1.setnSerie(nSerie);
				c1.setModelo(modelo);
				c1.setMarca(marca);
				c1.setAñoFabricacion(añoFabricacion);
				
				
				
				
				System.out.println("Dame el número de puertas");
				c1.setnPuertas(Console.readInt());
				System.out.println("¿Cúal es la capacidad del maletero?");
				c1.setCapacidadMaletero(Console.readInt());
			
				cbd.insertarVehiculo(c1);
			
				System.out.println();
				System.out.println();
				System.out.println("¡Has insertado un coche con exito!");
			
			
			}
			if(cocheOCamion==2) {
				
				ca1.setTipo("Camion");				
			
				ca1.setnBastidor(nBastidor);
				ca1.setMatricula(matricula);
				ca1.setColor(color);
				ca1.setnAsientos(nAsientos);
				ca1.setPrecio(precio);
				ca1.setnSerie(nSerie);
				ca1.setModelo(modelo);
				ca1.setMarca(marca);
				ca1.setAñoFabricacion(añoFabricacion);
				
				System.out.println("¿Cúal es la capacidad maxima de la carga");
				ca1.setCarga(Console.readInt());
				System.out.println("¿Cúal es el tipo de mercancía?");
				ca1.setTipoMercancia(Console.readString());;
				
				System.out.println();
				System.out.println();
				System.out.println("¿Has insertado un camión con exito!");
			
			
			}
			
		}
		
		if(numero==1) {
			
			xm1.leerXML();
			
		}
		
		
		
	}
	
	
	
}
