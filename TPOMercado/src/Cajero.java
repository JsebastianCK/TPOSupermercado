
public class Cajero implements Runnable{
	
	private Caja caja;
	
	public Cajero(Caja caja) {
		this.caja = caja;
	}
	
	public void run() {
		while(true) {
			caja.get();
		}
	}
	
}
