public class Cola {
	
	/*
	 * Esta cola representa a la cinta que hay en la caja
	 * 
	 * */
	
	private static final int TAM = 15;
	private Producto[] cola;
	private int fin, frente;

	public Cola() {
		this.cola = new Producto[TAM];
		this.fin = 0;
		this.frente = 0;
	}

	public boolean poner(Producto elto) {
		boolean resp = false;

		if (!((fin + 1) % TAM == frente)) {
			cola[fin%TAM] = elto;
			resp = true;
		}

		return resp;
	}

	public boolean sacar() {
		boolean resp = false;

		if (!esVacia()) {
			this.frente = ((this.frente + 1) % TAM);
			resp = true;
		}
		return resp;

	}

	public Producto obtenerFrente() {
		return cola[this.fin];
	}

	public boolean esVacia() {
		return this.frente == this.fin;
	}

	public void vaciar() {
		this.frente = 0;
		this.fin = 0;
	}
	
	public int length() {
		return TAM;
	}
	
}