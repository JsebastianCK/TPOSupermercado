import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Supermercado {
	
	public static void main(String[] args) {
		//El supermercado vende 15 articulos distintos.
		Producto[] productos = new Producto[15];		
		Caja[] cajas = new Caja[3];
		Timer timer = new Timer();
		
		//Se cargan los productos, las cajas y los clientes.
		cargarProductos(productos);
		cargarCajas(cajas);
		cargarClientes(cajas, productos);
		
		TimerTask dia = new TimerTask() {

			@Override
			public void run() {
				
			}
			
		};
		
		timer.schedule(dia, 10000, 10000);
		
	}
	
	public static void cargarProductos(Producto[] productos) {
		//Carga productos de manera aleatoria
		Random r = new Random();
		int precio , stock;
		boolean oferta;
		
		for(int i = 0; i < productos.length; i++) {
			
			//Valores aleatorios
			precio = (r.nextInt(199) + 1);
			stock = (r.nextInt(19) + 1);
			oferta = r.nextBoolean();
			
			productos[i] = new Producto(i , precio , stock , oferta);
		}
	}
	
	public static void cargarCajas(Caja[] cajas) {
		//Carga las cajas del supermercado
		for(int i = 0; i < cajas.length; i++) {
			cajas[i] = new Caja(i);
		}
	}
	
	public static void cargarClientes(Caja[] cajas , Producto[] productos) {
		//Clientes
		Cliente jorge = new Cliente("Jorge" , cajas , productos);
		Cliente raul = new Cliente("Raul" , cajas , productos);
		Cliente francisco = new Cliente("Francisco" , cajas , productos);
		Cliente valentina = new Cliente("Valentina" , cajas , productos);
		
		//Threads
		Thread t1 = new Thread(jorge);
		Thread t2 = new Thread(raul);
		Thread t3 = new Thread(francisco);
		Thread t4 = new Thread(valentina);
		
		//Inicio de los threads
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
	//Esto esta para prueba
	public static void mostrarSituacion(Producto[] productos) {
		System.out.println("Asi termino el dia: ");
		for(Producto n: productos) {
			System.out.println(n.toString());
		}
	}
	
	
}
