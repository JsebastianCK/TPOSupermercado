
public class Producto {
	
	private int id;
	private double precio;
	private int tiempoDeOferta;
	private int stock;
	private boolean oferta;
	
	public Producto(int id, double precio, int stock, boolean oferta){
		this.id = id;
		this.precio = precio;
		this.stock = stock;
		this.oferta = oferta;
		this.tiempoDeOferta = 1;
	}
	
	public synchronized void restarCantidad() {
		this.stock--;		
	}
	
	public synchronized void reponerCantidad(int cant) {
		//Repone el stock del producto.
		this.stock = this.stock + cant;
		System.out.println("El proveedor " + Thread.currentThread().getName() + " repuso el producto " + this.getId() + " stock ahora: " + this.getStock());
	}
	
	public synchronized int getStock() {
		return stock;
	}
	
	public void aumentarDia() {
		this.tiempoDeOferta++;
	}
	
	public boolean stockMinimo(){
		//Devuelve verdadero si hay poco stock del producto. Devuelve falso en caso contrario
		return this.stock < 5;
	}
	
	//OTROS GETTERS Y SETTERS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getTiempoDeOferta() {
		return tiempoDeOferta;
	}

	public boolean isOferta() {
		return oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}
	
	public String toString() {
		return "Producto: " + this.id + " Precio: " + this.precio + " Stock: " + this.stock + " Oferta: " + this.oferta;
	}
	
}
