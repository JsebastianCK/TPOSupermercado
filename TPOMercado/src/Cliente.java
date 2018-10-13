import java.util.Random;

public class Cliente implements Runnable{
	
	private String nombre;
	private Caja[] posiblesCajas;
	private Producto[] carroDeCompra;
	private Producto[] productosDelSuper;
	private Tiempo tiempo;
	
	public Cliente(String nombre, Caja[] posiblesCajas, Producto[] productosDelSuper , Tiempo tiempo) {
		this.nombre = nombre;
		this.posiblesCajas = posiblesCajas;
		this.productosDelSuper = productosDelSuper;
		this.tiempo = tiempo;
	}
	
	public void run() {
		try {
			while(true) {
				if(this.tiempo.estadoSuper()) {								//Me fijo si el supermercado esta abierto.
					System.out.println(this.getNombre() + " esta comprando.");
					this.llenarCarro();
					this.comprar();
					Thread.sleep(2500);											//El cliente espera un tiempo antes de volver a comprar.
				} else {
					System.err.println(this.getNombre() + " intento entrar al super pero estaba cerrado.");
					Thread.sleep(5000);											//El cliente intento entrar pero no pudo. Espera.
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
				
				try {
					Thread.sleep(100);				//Duerme durante 0.1 segs por cada producto que lleva
				} catch (Exception e){
					e.printStackTrace();
				}
				
				producto.restarCantidad();
			}
		}
	}
	
	public void comprar() {
		//El cliente se dirige hacia una caja para finalizar la compra.
		Random r = new Random();
		Caja caja = this.posiblesCajas[r.nextInt(this.posiblesCajas.length-1)];	//Se elige una caja aleatoriamente
		double total = 0;
		
		for(int i = 0; i < carroDeCompra.length; i++) {
			if(carroDeCompra[i] != null) {
				caja.put(carroDeCompra[i]);
				if(carroDeCompra[i].isOferta())
					total += (carroDeCompra[i].getPrecio()*0.9);		//Si el producto esta de oferta se aplica el descuento.
				else
					total += carroDeCompra[i].getPrecio();				//Sino se pone el precio completo.
			}
		}
		
		System.out.println(this.getNombre() + " termino de comprar. Precio de la compra: " + total);
		
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
