import java.util.Random;

public class Cliente implements Runnable{
	
	private String nombre;
	private Caja[] posiblesCajas;
	private Producto[] carroDeCompra;
	private Producto[] productosDelSuper;
	private boolean yaCompro;
	
	public Cliente(String nombre, Caja[] posiblesCajas, Producto[] productosDelSuper) {
		this.nombre = nombre;
		this.posiblesCajas = posiblesCajas;
		this.productosDelSuper = productosDelSuper;
		this.yaCompro = false;
	}
	
	public void run() {
		while(true) {
			if(!this.yaCompro) {
				this.llenarCarro();
				this.comprar();
				this.yaCompro = true;
			}
		}
	}
	
	public void reset() {
		this.yaCompro = false;
	}
	
	public void llenarCarro() {
		//El cliente va a llenar su carro. Este tiene un tamaño aleatorio de hasta un maximo de 15 productos.
		Random r = new Random();
		this.carroDeCompra = new Producto[r.nextInt(14) + 1];
		
		for(int i = 0; i < this.carroDeCompra.length; i++){	
			Producto producto = this.productosDelSuper[r.nextInt(this.productosDelSuper.length-1)];
			//Si hay stock del producto se lo agrega al carro
			if(producto.getStock() > 0) {
				this.carroDeCompra[i] = producto;
				producto.restarCantidad();
			}
		}
	}
	
	public void comprar() {
		//El cliente se dirige hacia una caja para finalizar la compra.
		Random r = new Random();
		Caja caja = this.posiblesCajas[r.nextInt(this.posiblesCajas.length-1)];	//Se elige una caja aleatoriamente
		caja.realizarCompra(this);
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
