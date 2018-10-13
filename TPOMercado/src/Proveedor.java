import java.util.Random;

public class Proveedor implements Runnable{

	private Producto[] productos;
	private Tiempo tiempo;
	
	public Proveedor(Producto[] productos , Tiempo tiempo) {
		this.productos = productos;
		this.tiempo = tiempo;
	}
	
	public void run() {
		while(true){
			try {
				if(this.tiempo.estadoSuper()) {		//Repone solo si el supermercado esta abierto.
					this.reponer();
					Thread.sleep(15000);			//Espera 15 segundos para volver a reponer.
				} else {
					System.err.println("El proveedor intento acceder al super pero estaba cerrado");
					Thread.sleep(5000);				//Si no pudo reponer espera unos 5 segundos.
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void reponer() {
		//Repone 3 productos de manera aleatoria.
		Random r = new Random();
		Producto cualquiera;
		
		for(int i = 0; i < 3; i++) {
			cualquiera = productos[r.nextInt(productos.length-1)];		//Producto aleatorio
			cualquiera.reponerCantidad(5);								//Se repone el producto
		}
	}

}
