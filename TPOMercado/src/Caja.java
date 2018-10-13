public class Caja {
	
	/*
	 * Caja del supermercado (Actua como buffer).
	 */
	
	private int contenido = 0;
	private Cola cola = new Cola();
	
	public synchronized void get() {
		//El cajero toma lo que este en la caja
		while(contenido == 0) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Saco el elemento de la cinta de la caja
		cola.sacar();
		contenido--;
		notify();	
	}
	
	public synchronized void put(Producto producto) {
		//El cliente pone un producto en la cinta de la caja
		
		while(contenido >= 15) {		//La cinta tiene una capacidad maxima de 15 productos
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Se pone el producto en la cinta de la caja
		cola.poner(producto);
		contenido++;
		notify();
		
	}
	
}
