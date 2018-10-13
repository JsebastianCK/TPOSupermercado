
public class Tiempo implements Runnable{
	
	private boolean abierto;
	private int dia;
	private Producto[] productos;
	
	public Tiempo(Producto[] productos) {
		abierto = true;
		dia = 1;
		this.productos = productos;
	}
	
	public void run() {
		//Controla el tiempo que pasa en la simulacion
		
		try {
			while(true) {
				abierto = true;
				System.err.println("-----------Dia " + dia + " | VaRaTiJa-----------");
				Thread.sleep(10000);													//El supermercado esta abierto durante 10 segs
				System.err.println("-----------VaRaTiJa esta cerrado-----------");
				abierto = false;
				dia++;
				Thread.sleep(2500);														//El supermercado permanece cerrado durante 2.5 segs				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean estadoSuper() {
		return abierto;
	}
	
	public int getDia() {
		return dia;
	}

	public void aumentarDia() {
		//Pasa un dia en el supermercado
		dia++;
		
		//Si un producto esta de oferta entonces aumento su cantidad de dias.
		for(Producto producto : productos) {
			if(producto.isOferta()) {
				producto.aumentarDia();
			}
		}
	}
	
}
