package modelos;

import java.math.BigDecimal;

public class Plato {
	private final int idPlato;
	private final String nombrePlato;
	private BigDecimal precioVenta;
	private BigDecimal costoProduccion;
	
	
	public Plato(int idPlato, String nombrePlato, BigDecimal precioVenta, BigDecimal costoProduccion) {
		this.idPlato = idPlato;
		this.nombrePlato = nombrePlato;
		this.precioVenta = precioVenta;
		this.costoProduccion = costoProduccion;
	}


	public int getIdPlato() {
		return idPlato;
	}
	
	public String getNombrePlato() {
		return nombrePlato;
	}
	
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	public BigDecimal getCostoProduccion() {
		return costoProduccion;
	}
	public void setCostoProduccion(BigDecimal costoProduccion) {
		this.costoProduccion = costoProduccion;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)return true;
		if (!(obj instanceof Plato)) return false;
		Plato p = (Plato) obj;
		return (this.idPlato == p.getIdPlato());
	}


	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombrePlato=" + nombrePlato + ", precioVenta=" + precioVenta + ", costoProduccion=" + costoProduccion + "]";
	}

}
