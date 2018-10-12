import java.util.ArrayList;

public class Gerente implements Runnable{
	
	private ArrayList<Producto> ofertas = new ArrayList<Producto>();
	private Producto[] productos;
	
	public Gerente(Producto[] productos) {
		this.productos = productos;
		obtenerOfertas(productos);
	}
	
	public void run() {
		
	}
	
	public void obtenerOfertas(Producto[] productos) {
		//Agarra todos los productos que estan en oferta y los mete en la lista de ofertas.
		for(Producto n: productos) {
			//Si el producto esta de oferta lo agrego a la lista.
			if(n.isOferta())
				ofertas.add(n);
		}
	}
	
}
