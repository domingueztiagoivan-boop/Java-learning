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
	
	///Primero comprobar que si son lo mismo, devuelva true, despues comprobar que son del mismo tipo y por ultimo comparar el atributo unico identificador.
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Repartidor)) return false;
		Repartidor o = (Repartidor) obj;
		return (this.patenteIdentificador.equals(o.patenteIdentificador));
	}
	

	
	@Override
	public String toString() {
		return "Repartidor [id=" + id + ", patenteIdentificador=" + patenteIdentificador + ", capacidadPedidosMax="
				+ capacidadPedidosMax + "]";
	}


	/// el hashcode debe hacerse con el mismo atributo que el equals, osea patenteIdentificador.. STRING TIENE SU PROPIO HASCODE, NO HACE FALTA HACERLO NOSOTROS.
	@Override
	public int hashCode(){
		return patenteIdentificador.hashCode();
	}


	public abstract float costoTotalEnvio(float kmRecorridos);
	
	public abstract String getTipo();
}
