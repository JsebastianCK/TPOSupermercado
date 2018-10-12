
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
		this.tiempoDeOferta = 0;
	}
	
	public synchronized void restarCantidad() {
		this.stock--;
	}
	
	public synchronized void reponerCantidad(int cant) {
		this.stock = this.stock + cant;
	}
	
	public synchronized int getStock() {
		return stock;
	}
	
	public void aumentarDia() {
		this.tiempoDeOferta++;
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
