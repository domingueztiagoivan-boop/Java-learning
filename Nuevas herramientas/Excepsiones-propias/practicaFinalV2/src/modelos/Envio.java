package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Envio {
	private int id;
	private LocalDate fecha;
	private Mesa mesa;
	private Repartidor repartidor;
	private int cantPedidosAsignados;
	private float kmRecorridos;
	
	///QUE ES Objects.requireNonNull()? EXCEPTION UNCHECKED QUE SE LANZA SI EL OBJETO ES NULL.
	///Es un método de utilidad que se encuentra en la clase Objects de Java.
	///Su proposito es verificar que las variables que llegan no sean null, y lanzar una excepción si lo son.

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
		this.kmRecorridos = kmRecorridos;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public Repartidor getRepartidor() {
		return repartidor;
	}
	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}
	public int getCantPedidosAsignados() {
		return cantPedidosAsignados;
	}
	public void setCantPedidosAsignados(int cantPedidosAsignados) throws ExceptionRepartidor{
		if (cantPedidosAsignados > repartidor.getCapacidadPedidosMax()) throw new ExceptionRepartidor(repartidor.getCapacidadPedidosMax(), cantPedidosAsignados);
		this.cantPedidosAsignados = cantPedidosAsignados;
	}
	public float getKmRecorridos() {
		return kmRecorridos;
	}
	public void setKmRecorridos(float kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	@Override
	public String toString() {
		return "Envio [id=" + id + ", fecha=" + fecha + ", mesa=" + mesa + ", repartidor=" + repartidor + ", cantPedidosAsignados=" + cantPedidosAsignados + ", kmRecorridos=" + kmRecorridos + "]";
	}
	
	public boolean equals(Envio envio) {
		return (this.id == envio.getId());
	}
	
}
