package modelos;

import java.math.BigDecimal;
import java.util.Objects;

public class Plato {
	private final int idPlato;
	private final String nombrePlato;
	private BigDecimal precioVenta;
	private BigDecimal costoProduccion;
	
	
	public Plato(int idPlato, String nombrePlato, BigDecimal precioVenta, BigDecimal costoProduccion) throws ExceptionMenorZero{
		Objects.requireNonNull(nombrePlato, "ERROR. El nombre no puede ser un atributo null.");
		Objects.requireNonNull(precioVenta, "ERROR. El precio venta no puede ser un atributo null.");
		Objects.requireNonNull(costoProduccion, "ERROR. El costo produccion no puede ser un atributo null.");
		this.idPlato = validarId(idPlato);
		this.nombrePlato = nombrePlato;
		this.precioVenta = validarPrecio(precioVenta);
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
	public void setPrecioVenta(BigDecimal precioVenta)throws ExceptionMenorZero {
		this.precioVenta = validarPrecio(precioVenta);
	}
	public BigDecimal getCostoProduccion() {
		return costoProduccion;
	}
	public void setCostoProduccion(BigDecimal costoProduccion) {
		this.costoProduccion = costoProduccion;
	}
	
	@Override
	public int hashCode(){
		return nombrePlato.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if(this == obj)return true;
		if (!(obj instanceof Plato)) return false;
		Plato p = (Plato) obj;
		return (this.nombrePlato.equals(p.getNombrePlato()));
	}


	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombrePlato=" + nombrePlato + ", precioVenta=" + precioVenta + ", costoProduccion=" + costoProduccion + "]";
	}


	private static int validarId(int id)throws ExceptionMenorZero{
			if (id < 0)throw new ExceptionMenorZero("ERROR. El id debe ser mayor o igual a 0.");
			return id; 
	}


	private static BigDecimal validarPrecio(BigDecimal precio)throws ExceptionMenorZero{
			if (precio.compareTo(BigDecimal.ZERO) < 0)throw new ExceptionMenorZero("ERROR. El id debe ser mayor o igual a 0.");
			return precio; 
	}	
}
