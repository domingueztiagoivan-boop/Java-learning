package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Festival {
	private final int idFestival;
	private final String nombreFestival;
	private final String temporadaFestival;
	private final LocalDate fechaInicio;
	private final LocalDate fechaFin;
	private final Costo costoFestival;
	private final List<Pedido> lstPedidos;
	

	public Festival(int idFestival, String nombreFestival, String temporadaFestival, LocalDate fechaInicio, LocalDate fechaFin, Costo costoFestival) {
			this.idFestival = idFestival;
			this.nombreFestival = nombreFestival;
			this.temporadaFestival = temporadaFestival;
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
			this.costoFestival = costoFestival;
			this.lstPedidos = new ArrayList<Pedido>();
		}


	public int getIdFestival() {
		return idFestival;
	}


	
	public String getNombreFestival() {
		return nombreFestival;
	}
	
	public String getTemporadaFestival() {
		return temporadaFestival;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
	public Costo getCostoFestival() {
		return costoFestival;
	}
	
	public List<Pedido> getLstPedidos(){
		return this.lstPedidos;
	}
	


	@Override
	public String toString() {
		return "Festival [idFestival=" + idFestival + ", nombreFestival=" + nombreFestival + ", temporadaFestival=" + temporadaFestival + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", costoFestival=" + costoFestival + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Festival)) return false;
		Festival f = (Festival) obj;
		return (this.idFestival == f.getIdFestival());
	}

	@Override
	public int hashCode(){
		return Integer.hashCode(idFestival);
	}
	
	public Pedido traerPedidoFestival(int idPedido) {
		 
		Pedido resultado = null;
		int i = 0;
		
		while (i < this.lstPedidos.size() && resultado == null) {
			if (this.lstPedidos.get(i).getIdPedido() == idPedido) {
				resultado = this.lstPedidos.get(i);
			}
			i++;
		}
		return resultado;
	}
	
	public boolean agregarPedidoFestival(Pedido pedido)throws ExceptionYaRegistrado{
		if (traerPedidoFestival(pedido.getIdPedido()) != null) throw new ExceptionYaRegistrado("ERROR. El pedido " + pedido.getIdPedido() + " ya esta registrado en los pedidos festival.");
		
		return this.lstPedidos.add(pedido);
	}

}
