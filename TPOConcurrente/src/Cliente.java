import java.util.Random;

public class Cliente implements Runnable{
	
	private String nombre;
	private Caja[] posiblesCajas;
	private Producto[] carroDeCompra;
	private Producto[] productosDelSuper;
	
	public Cliente(String nombre, Caja[] posiblesCajas, Producto[] productosDelSuper) {
		this.nombre = nombre;
		this.posiblesCajas = posiblesCajas;
		this.productosDelSuper = productosDelSuper;
	}

	public void run() {
		
	}
	
	public void comprar(){
		//El cliente va a llenar su carro. Este tiene un tamaño aleatorio de hasta un maximo de 15 productos.
		Random r = new Random();
		this.carroDeCompra = new Producto[r.nextInt(14) + 1];
		
		for(int i = 0; i < this.carroDeCompra.length; i++){
			
		}
		
	}
	
	public void vaciarCarro() {
		//Vacia el carro del cliente
		for(int i = 0; i < this.carroDeCompra.length; i++) {
			this.carroDeCompra[i] = null;
		}
	}
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Producto[] getCarroDeCompra() {
		return carroDeCompra;
	}
}
