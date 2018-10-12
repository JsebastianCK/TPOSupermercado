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
		double precio = 0;
		try {
			
			//El cliente agarra el permiso de la caja.
			this.atendiendo.acquire();
			System.out.println("La caja " + this.numeroDeCaja + " esta procesando la compra de " + cliente.getNombre() + ".");
			
			//Procesa cada uno de los productos en el carro de compra
			for(int i = 0; i < cliente.getCarroDeCompra().length; i++) {
				if(cliente.getCarroDeCompra()[i] != null) {
					if(cliente.getCarroDeCompra()[i].isOferta())
						precio += (cliente.getCarroDeCompra()[i].getPrecio()*(0.9));	//Sumo el precio del producto al total de la compra (con descuento)
					else
						precio += cliente.getCarroDeCompra()[i].getPrecio();			//Sumo el precio del producto al total de la compra (sin descuento)
					
					Thread.sleep(250);													//Simula el procesamiento esperando 0.25 segs
				}
			}
			
			//La compra ya fue procesada asi que se vacia el carro de compra y se suelta el permiso.
			cliente.vaciarCarro();
			System.out.println("La caja " + this.numeroDeCaja + " finalizo la compra de " + cliente.getNombre() + ". Total: $" + precio);
			this.atendiendo.release();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
