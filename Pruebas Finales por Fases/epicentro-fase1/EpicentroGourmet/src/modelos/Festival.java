package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Festival {
	private final int idFestival;
	private final String nombreFestival;
	private final Temporada temporadaFestival;
	private final LocalDate fechaInicio;
	private final LocalDate fechaFin;
	private final Costo costoFestival;
	private final List<Pedido> lstPedidos;
	

	public Festival(int idFestival, String nombreFestival, Temporada temporadaFestival, LocalDate fechaInicio, LocalDate fechaFin, Costo costoFestival)throws ExceptionMenorZero, ExceptionFechasLimites {
			Objects.requireNonNull(nombreFestival, "ERROR. El nombre no puede ser un atributo null.");
			Objects.requireNonNull(temporadaFestival, "ERROR. La temporada no puede ser un atributo null.");
			Objects.requireNonNull(fechaInicio, "ERROR. La fecha inicio no puede ser un atributo null.");
			Objects.requireNonNull(fechaFin, "ERROR. La fecha fin no puede ser un atributo null.");
			Objects.requireNonNull(costoFestival, "ERROR. El costo festival no puede ser un atributo null.");

			this.idFestival = validarId(idFestival);
			this.nombreFestival = nombreFestival;
			this.temporadaFestival = temporadaFestival;
			this.fechaInicio = fechaInicio;
			this.fechaFin = validarFechaFin(fechaFin);
			this.costoFestival = costoFestival;
			this.lstPedidos = new ArrayList<Pedido>();
		}


	public int getIdFestival() {
		return idFestival;
	}


	
	public String getNombreFestival() {
		return nombreFestival;
	}
	
	public Temporada getTemporadaFestival() {
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
		return List.copyOf(lstPedidos);
	}
	


	@Override
	public String toString() {
		return "Festival [idFestival=" + idFestival + ", nombreFestival=" + nombreFestival + ", temporadaFestival=" + temporadaFestival.getDescripcion() + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", costoFestival=" + costoFestival + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Festival)) return false;
		Festival f = (Festival) obj;
		return (this.nombreFestival.equals(f.getNombreFestival()));
	}

	@Override
	public int hashCode(){
		return nombreFestival.hashCode();
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
	

	private static int validarId(int id)throws ExceptionMenorZero{
		if (id < 0)throw new ExceptionMenorZero("ERROR. El id debe ser mayor o igual a 0.");
		return id;
	}

	private LocalDate validarFechaFin(LocalDate fin)throws ExceptionFechasLimites{
		if (fin.isAfter(fechaInicio))throw new ExceptionFechasLimites("ERROR. La fecha fin debe ser despues que la fecha de inicio.");
		return fin;
	}
}	
