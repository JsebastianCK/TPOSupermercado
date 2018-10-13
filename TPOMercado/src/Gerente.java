import java.util.ArrayList;
import java.util.Random;

public class Gerente implements Runnable{
	
	private ArrayList<Producto> ofertas = new ArrayList<Producto>();
	private Producto[] productos;
	private Tiempo tiempo;
	
	public Gerente(Producto[] productos , Tiempo tiempo) {
		this.productos = productos;
		obtenerOfertas(productos);
		this.tiempo = tiempo;
	}
	
	public void run() {
		while(true){
			try{
				Random r = new Random();
				
				if(r.nextInt(100) < 3) {			//Hay un 3% de probabilidades de que el gerente cambie una oferta.
					this.cambiarOferta();
					System.out.println("El gerente cambio un producto de oferta.");
				}
				
				if(this.tiempo.getDia()%7 == 0) {	//Cada una semana ocurre esto.
					this.cambiarOfertasVencidas();
					System.out.println("El gerente cambio las ofertas viejas");
					Thread.sleep(5000);
				}
				
				this.verificarStock();				//Verifica que no haya stock minimo en los productos que estan de oferta.
				Thread.sleep(5000);					//El gerente duerme un rato porque esta cansado.
				
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private void obtenerOfertas(Producto[] productos) {
		//Agarra todos los productos que estan en oferta y los mete en la lista de ofertas.
		for(Producto n: productos) {
			//Si el producto esta de oferta lo agrego a la lista.
			if(n.isOferta())
				ofertas.add(n);
		}
	}
	
	private void cambiarOferta() {
		//Se cambia una oferta aleatoriamente
		Random r = new Random();
		Producto nuevo , viejo;
		
		do {
			nuevo = productos[r.nextInt(productos.length - 1)];			//Se elige un producto que no este de oferta.
		} while(nuevo.isOferta());
		
		viejo = ofertas.get(r.nextInt(ofertas.size()-1));				//Se obtiene un producto en oferta aleatorio.
		viejo.setOferta(false);											//Deja de estar en oferta
		ofertas.remove(viejo);											//Se elimina de la lista de productos en oferta.
		nuevo.setOferta(true);											//El producto nuevo se pone de oferta.
		ofertas.add(nuevo);												//Se agrega el nuevo producto a la lista de ofertas del gerente.
	}

	private void cambiarOfertasVencidas() {
		//Cambia todas las ofertas vencidas
		int cant = 0;		//Este contador cuenta cuantas ofertas hay vencidas para luego poder reemplazarlas.
		Producto nuevo;
		
		//Se eliminan los productos vencidos.
		for(Producto producto : productos) {
			if(producto.getTiempoDeOferta() == 7) {
				producto.setOferta(false);
				ofertas.remove(producto);
			}
		}
		
		//Agrego productos nuevos a la lista de productos.
		for(int i = 0; i < cant; i++) {
			nuevo = obtenerProducto();
			nuevo.setOferta(true);
			ofertas.add(nuevo);
		}
	}
	
	private void verificarStock() {
		//Si algun producto tiene stock minimo entonces se reemplazara la oferta por otro producto.
		Producto nuevo;
		
		for(Producto producto : productos) {
			if(producto.isOferta() && producto.stockMinimo()) {
				System.out.println("El producto " + producto.getId() + " tiene poco stock por lo que deja de estar en oferta.");
				producto.setOferta(false);						//Se lo saca de oferta.
				nuevo = obtenerProducto();						//Se obtiene un producto nuevo para colocar de oferta
				nuevo.setOferta(true);							//Se pone de oferta el producto nuevo
				ofertas.add(nuevo);								//Se coloca el producto nuevo en la lista de ofertas.
				ofertas.remove(producto);						//Se elimina al producto de la lista de ofertas.
			}
		}
	}
	
	private Producto obtenerProducto() {
		//Devuelve un producto aleatorio del supermercado que NO se encuentra en oferta
		Random r = new Random();
		Producto random;
		
		do {
			random = productos[r.nextInt(productos.length-1)];		//Producto aleatorio del super.
		} while(random.isOferta());
		
		return random;
	}
	
}
