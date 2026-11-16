package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Envio {
	private final int id;
	private final LocalDate fecha;
	private final Mesa mesa;
	private final Repartidor repartidor;
	private int cantPedidosAsignados;
	private float kmRecorridos;
	
	///QUE ES Objects.requireNonNull()? EXCEPTION UNCHECKED QUE SE LANZA SI EL OBJETO ES NULL.
	///Es un método de utilidad que se encuentra en la clase Objects de Java.
	///Su proposito es verificar que las variables que llegan no sean null, y lanzar una excepción si lo son.
	///
	///
	///
	///FALTA MUCHOS EXCEPTION POR RESOLVER, POR EJEMPLO KMRECORRIDOS NEGATIVOS. 
	///CANTIDAD DE PEDIDOS ASIGNADOS MAYOR A LA CAPACIDAD DEL REPARTIDOR. ETC.
	///PARA PROYECTO FINAL CORREGIR TODOO.

	public Envio(int id, LocalDate fecha, Mesa mesa, Repartidor repartidor, int cantPedidosAsignados, float kmRecorridos) throws ExceptionRepartidor {
		super();
		Objects.requireNonNull(fecha, "La fecha no puede ser nula");
		Objects.requireNonNull(mesa, "La mesa no puede ser nula");
		Objects.requireNonNull(repartidor, "El repartidor no puede ser nulo");
		this.id = id;
		this.fecha = fecha;
		this.mesa = mesa;
		this.repartidor = repartidor;
		setCantPedidosAsignados(cantPedidosAsignados);
		this.kmRecorridos = validarKmRecorridos(kmRecorridos);
	}


	/// ELIMINAMOS LOS SET QUE NO QUEREMOS QUE CAMBIEN DATOS IMPORTANTES; COMO ID, KMRECORRIDOS, FECHA, MESA Y REPARTIDOR. 
	///SOLO PODEMOS CAMBIAR CANTIDAD DE PEDIDOS ASIGNADOS.

	public int getId() {
		return id;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public Mesa getMesa() {
		return mesa;
	}
	
	public Repartidor getRepartidor() {
		return repartidor;
	}

	public int getCantPedidosAsignados() {
		return cantPedidosAsignados;
	}
	public void setCantPedidosAsignados(int cantPedidosAsignados) throws ExceptionRepartidor{
		if (cantPedidosAsignados > repartidor.getCapacidadPedidosMax()) throw new ExceptionRepartidor("Error. Los pedidos asignados [" + cantPedidosAsignados + "] superan la cantidad del repartidor maxima [" + repartidor.getCapacidadPedidosMax() + "].");
		if (cantPedidosAsignados <= 0) throw new ExceptionRepartidor("Error. La cantidad de pedidos asignados no puede ser negativa.");
		this.cantPedidosAsignados = cantPedidosAsignados;
	}
	public float getKmRecorridos() {
		return kmRecorridos;
	}

	public float validarKmRecorridos(float kmRecorridos) throws ExceptionRepartidor{
		if (kmRecorridos <= 0) throw new ExceptionRepartidor("Error. Los kilómetros recorridos no pueden ser negativos.");
		return kmRecorridos;
	}

	@Override
	public String toString() {
		return "Envio [id=" + id + ", fecha=" + fecha + ", mesa=" + mesa + ", repartidor=" + repartidor + ", cantPedidosAsignados=" + cantPedidosAsignados + ", kmRecorridos=" + kmRecorridos + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Envio)) return false;
		Envio other = (Envio) obj;
		return this.id == other.getId(); 
	}
	

	@Override
	public int hashCode() {
		return Integer.hashCode(id);
	}
}
