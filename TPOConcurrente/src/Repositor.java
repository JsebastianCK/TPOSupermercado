import java.util.Random;

public class Repositor implements Runnable{

	private Producto[] productos;
	
	public Repositor(Producto[] productos) {
		this.productos = productos;
	}
	
	public void run() {
		this.reponer();
		System.out.println("El repositor repuso productos.");
	}
	
	public void reponer() {
		//Repone 3 elementos de manera aleatoria
		Random r = new Random();
		int longitud = productos.length;
		
		for(int i = 0; i < 3; i++) {
			productos[r.nextInt(longitud-1)].reponerCantidad(5);	//Repone el producto
		}
	}

}
