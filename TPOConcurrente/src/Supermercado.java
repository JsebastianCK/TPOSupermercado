import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Supermercado {
	
	private static int dia = 1;
	
	public static void main(String[] args) {
		//El supermercado vende 15 articulos distintos.
		Producto[] productos = new Producto[15];		
		Caja[] cajas = new Caja[8];
		Timer timer = new Timer();
		
		//Se cargan los productos y las cajas.
		cargarProductos(productos);
		cargarCajas(cajas);
		
		mostrarSituacion(productos);
		//Simula el paso de dias
		System.out.println("---------------------DIA 1 / VaRaTiJa---------------------");
		TimerTask pasoDia = new TimerTask() {
		    @Override
		    public void run() {
		    	try {
		    		System.out.println("Supermercado cerrado");  	
		    		mostrarSituacion(productos);
			    	Thread.sleep(3000);
			    	dia++;
			    	System.out.println("---------------------DIA " + dia + " / VaRaTiJa---------------------");
		    	} catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    }
		};
		
		//Clientes
		Cliente jorge = new Cliente("Jorge" , cajas , productos);
		Cliente raul = new Cliente("Raul" , cajas , productos);
		
		Thread t1 = new Thread(jorge);
		Thread t2 = new Thread(raul);
		
		//Inicio de los threads
		t1.start();
		t2.start();
		
		//Pasa un dia luego de 10 segs de ejecucion
		timer.schedule(pasoDia , 10000 , 10000);
		
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
	
	//Esto esta para prueba
	public static void mostrarSituacion(Producto[] productos) {
		System.out.println("Asi termino el dia: ");
		for(Producto n: productos) {
			System.out.println(n.toString());
		}
	}
	
	
}
