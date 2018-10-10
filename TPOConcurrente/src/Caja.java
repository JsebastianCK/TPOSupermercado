import java.util.concurrent.Semaphore;

public class Caja {
	
	private int numeroDeCaja;
	private Semaphore atendiendo;
	
	public Caja(int numeroDeCaja) {
		this.numeroDeCaja = numeroDeCaja;
		this.atendiendo = new Semaphore(1);
	}
	
	public void realizarCompra(Cliente cliente) {
		//La caja procesa la compra del cliente.
		try {
			
			this.atendiendo.acquire();
			System.out.println("La caja " + this.numeroDeCaja + " esta procesando la compra de " + cliente.getNombre() + ".");
			
			//Procesa cada uno de los productos en el carro de compra
			for(int i = 0; i < cliente.getCarroDeCompra().length; i++) {
				if(cliente.getCarroDeCompra()[i] != null) {
					Thread.sleep(250);			//Simula el procesamiento esperando 0.25 segs
				}
			}
			
			cliente.vaciarCarro();
			System.out.println("La caja " + this.numeroDeCaja + " esta disponible.");
			this.atendiendo.release();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
