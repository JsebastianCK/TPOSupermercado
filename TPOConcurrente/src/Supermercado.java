import java.util.Random;

public class Supermercado {
	public static void main(String[] args) {
		Producto[] productos = new Producto[15];
		
		cargarProductos(productos);
		
	}
	
	public static void cargarProductos(Producto[] productos) {
		//Carga productos de manera aleatoria
		Random r = new Random();
		int precio , stock;
		boolean oferta;
		
		for(int i = 0; i < productos.length; i++) {
			
			//Valores aleatorios
			precio = (r.nextInt(199) + 1);
			stock = (r.nextInt(19) + 1);
			oferta = r.nextBoolean();
			
			productos[i] = new Producto(i , precio , stock , oferta);
		}
	}
	
}
