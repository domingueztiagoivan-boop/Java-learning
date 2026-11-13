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
	
	public Envio(int id, LocalDate fecha, Mesa mesa, Repartidor repartidor, int cantPedidosAsignados, float kmRecorridos) throws Exception{
		super();
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
	public void setCantPedidosAsignados(int cantPedidosAsignados) throws Exception{
		if (cantPedidosAsignados > repartidor.getCapacidadPedidosMax()) throw new Exception ("n\"Error. Los pedidos asignados superan la capacidad máxima del repartidor.\n");
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
	///Primero comprobar que si son lo mismo, devuelva true, despues comprobar que son del mismo tipo y por ultimo comparar el atributo unico identificador.
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Envio)) return false;
		Envio o = (Envio) obj;
		return (this.id == o.id);
	}


	/// el hashcode debe hacerse con el mismo atributo que el equals, osea ID en este caso.
	/// al ser un int tenemos que definir nosotros el hashcode, no como en el caso de String que ya tiene su propio hashcode. Tomamos ID atributo uncico identificador.
	@Override
	public int hashCode(){
		return Objects.hash(id);
	} 
	
	
}
