package modelos;

public abstract class Repartidor{
	protected int id;
	protected String patenteIdentificador;
	protected int capacidadPedidosMax;
	
	
	
	public Repartidor(int id, String patenteIdentificador, int capacidadPedidosMax) {
		this.id = id;
		this.patenteIdentificador = patenteIdentificador;
		this.capacidadPedidosMax = capacidadPedidosMax;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatenteIdentificador() {
		return patenteIdentificador;
	}

	public void setPatenteIdentificador(String patenteIdentificador) {
		this.patenteIdentificador = patenteIdentificador;
	}

	public int getCapacidadPedidosMax() {
		return capacidadPedidosMax;
	}

	public void setCapacidadPedidosMax(int capacidadPedidosMax) {
		this.capacidadPedidosMax = capacidadPedidosMax;
	}
	
	
	public boolean equals(Repartidor repartidor) {
		return (repartidor.getPatenteIdentificador().equals((this.patenteIdentificador)));
	}
	

	
	@Override
	public String toString() {
		return "Repartidor [id=" + id + ", patenteIdentificador=" + patenteIdentificador + ", capacidadPedidosMax="
				+ capacidadPedidosMax + "]";
	}



	public abstract float costoTotalEnvio(float kmRecorridos);
}
