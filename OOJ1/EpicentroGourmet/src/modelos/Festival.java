package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Festival {
	private int idFestival;
	private String nombreFestival;
	private String temporadaFestival;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Costo costoFestival;
	private List<Pedido> lstPedidos;
	

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


	public void setIdFestival(int idFestival) {
		this.idFestival = idFestival;
	}
	public String getNombreFestival() {
		return nombreFestival;
	}
	public void setNombreFestival(String nombreFestival) {
		this.nombreFestival = nombreFestival;
	}
	public String getTemporadaFestival() {
		return temporadaFestival;
	}
	public void setTemporadaFestival(String temporadaFestival) {
		this.temporadaFestival = temporadaFestival;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Costo getCostoFestival() {
		return costoFestival;
	}
	public void setCostoFestival(Costo costoFestival) {
		this.costoFestival = costoFestival;
	}
	public List<Pedido> getLstPedidos(){
		return this.lstPedidos;
	}
	public void setLstPedidos(List<Pedido> lstPedidos) {
		this.lstPedidos = lstPedidos;
	}


	@Override
	public String toString() {
		return "Festival [idFestival=" + idFestival + ", nombreFestival=" + nombreFestival + ", temporadaFestival=" + temporadaFestival + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", costoFestival=" + costoFestival + "]";
	}
	
	public boolean equals(Festival festival) {
		return (festival.getNombreFestival().equals(this.nombreFestival));
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
	
	public boolean agregarPedidoFestival(Pedido pedido)throws Exception{
		if (traerPedidoFestival(pedido.getIdPedido()) != null) throw new Exception("ERROR. El pedido " + pedido.getIdPedido() + " ya esta registrado en los pedidos festival.");
		
		return this.lstPedidos.add(pedido);
	}

}
