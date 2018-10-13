import java.util.Random;

public class Supermercado {
	
	public static void main(String[] args) {
		//El supermercado vende 15 articulos distintos.
		Producto[] productos = new Producto[15];		
		Caja[] cajas = new Caja[3];
		
		//Se cargan los productos
		cargarProductos(productos);
				
		//Control del dia
		Tiempo tiempo = new Tiempo(productos);
		Thread time = new Thread(tiempo);
		time.start();
		
		//Se cargan las cajas, el gerente, los clientes y los repositores.
		cargarCajas(cajas);
		cargarGerente(productos , tiempo);
		cargarClientes(cajas , productos , tiempo);
		cargarRepositores(productos , tiempo);
		
		
	}

	public static void cargarProductos(Producto[] productos) {
		//Carga productos de manera aleatoria
		Random r = new Random();
		int precio , stock;
		boolean oferta;
		
		for(int i = 0; i < productos.length; i++) {
			
			//Valores aleatorios
			precio = (r.nextInt(199) + 1);
			stock = (r.nextInt(14) + 1) + 10;
			oferta = r.nextBoolean();
			
			productos[i] = new Producto(i , precio , stock , oferta);
		}
	}
	
	public static void cargarCajas(Caja[] cajas) {
		//Carga las cajas del supermercado
		for(int i = 0; i < cajas.length; i++) {
			cajas[i] = new Caja();
		}
		
		//Cajeros
		Cajero c1 = new Cajero(cajas[0]);
		Cajero c2 = new Cajero(cajas[1]);
		Cajero c3 = new Cajero(cajas[2]);
		
		//Threads
		Thread cajero1 = new Thread(c1 , "C1");
		Thread cajero2 = new Thread(c2 , "C2");
		Thread cajero3 = new Thread(c3 , "C3");
		
		//Inicio de threads
		cajero1.start();
		cajero2.start();
		cajero3.start();
		
	}
	
	public static void cargarClientes(Caja[] cajas , Producto[] productos , Tiempo tiempo) {
		//Clientes
		Cliente jorge = new Cliente("Jorge" , cajas , productos , tiempo);
		Cliente raul = new Cliente("Raul" , cajas , productos , tiempo);
		Cliente francisco = new Cliente("Francisco" , cajas , productos , tiempo);
		Cliente valentina = new Cliente("Valentina" , cajas , productos , tiempo);
		Cliente roberta = new Cliente("Roberta" , cajas, productos , tiempo);
		
		//Threads
		Thread t1 = new Thread(jorge , "Jorge");
		Thread t2 = new Thread(raul , "Raul");
		Thread t3 = new Thread(francisco , "Francisco");
		Thread t4 = new Thread(valentina , "Valentina");
		Thread t5 = new Thread(roberta , "Roberta");
		
		//Inicio de los threads
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
	public static void cargarGerente(Producto[] productos , Tiempo tiempo){
		//Gerente
		Gerente gerente = new Gerente(productos , tiempo);
		
		//Thread
		Thread ger = new Thread(gerente);
		
		//Inicio de thread
		ger.start();
	}
	
	public static void cargarRepositores(Producto[] productos , Tiempo tiempo) {
		//Repositores
		Proveedor prov1 = new Proveedor(productos , tiempo);
		Proveedor prov2 = new Proveedor(productos , tiempo);
		Proveedor prov3 = new Proveedor(productos , tiempo);
		
		//Threads
		Thread p1 = new Thread(prov1 , "1");
		Thread p2 = new Thread(prov2 , "2");
		Thread p3 = new Thread(prov3 , "3");
		
		//Inicio de threads
		p1.start();
		p2.start();
		p3.start();
	}
	
	//Esto esta para prueba
	public static void mostrarSituacion(Producto[] productos) {
		System.out.println("Asi termino el dia: ");
		for(Producto n: productos) {
			System.out.println(n.toString());
		}
	}
	
	
}
