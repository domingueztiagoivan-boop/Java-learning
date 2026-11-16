package modelos;

import java.util.Objects;

public abstract class Repartidor{
	protected final int id;
	protected final String patenteIdentificador;
	protected int capacidadPedidosMax;
	
	
	
	public Repartidor(int id, String patenteIdentificador, int capacidadPedidosMax) throws ExceptionRepartidorMenorCero {
		Objects.requireNonNull(patenteIdentificador, "La patente identificador no puede ser nula");
		this.id = id;
		this.patenteIdentificador = patenteIdentificador;
		setCapacidadPedidosMax(capacidadPedidosMax);
	}



	/// ELIMINAMOS LOS SET QUE NO QUEREMOS QUE CAMBIEN DATOS IMPORTANTES; COMO ID y PATENTEIDENTIFICADOR.

	public int getId() {
		return id;
	}


	public String getPatenteIdentificador() {
		return patenteIdentificador;
	}


	public int getCapacidadPedidosMax() {
		return capacidadPedidosMax;
	}

	public void setCapacidadPedidosMax(int capacidadPedidosMax) throws ExceptionRepartidorMenorCero{ 
		if (capacidadPedidosMax <= 0) throw new ExceptionRepartidorMenorCero("[" + capacidadPedidosMax + "] No se puede asignar un repartidor con capacidad de pedidos menor o igual a cero");
		
		this.capacidadPedidosMax = capacidadPedidosMax;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Repartidor)) return false;
		Repartidor other = (Repartidor) obj;
		return this.patenteIdentificador.equals(other.getPatenteIdentificador());
		}
	
	@Override
	public int hashCode() {
		return patenteIdentificador.hashCode();
		}

	
	@Override
	public String toString() {
		return "Repartidor [id=" + id + ", patenteIdentificador=" + patenteIdentificador + ", capacidadPedidosMax="
				+ capacidadPedidosMax + "]";
	}



	public abstract float costoTotalEnvio(float kmRecorridos);

}
