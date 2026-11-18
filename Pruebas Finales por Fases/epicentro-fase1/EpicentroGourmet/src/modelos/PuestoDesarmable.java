package modelos;

import java.math.BigDecimal;

public class PuestoDesarmable extends UnidadVenta{
	private int cantidadCarpas;
	private int tiempoMontajeMinutos;
	
	
	public PuestoDesarmable(int idUnidadVenta, String nombreComercial, Personal responsable, double superficie, String codigo, int cantidadCarpas, int tiempoMontajeMinutos) {
		super(idUnidadVenta, nombreComercial, responsable, superficie, codigo);
		this.cantidadCarpas = cantidadCarpas;
		this.tiempoMontajeMinutos = tiempoMontajeMinutos;
	}


	public int getCantidadCarpas() {
		return cantidadCarpas;
	}
	public void setCantidadCarpas(int cantidadCarpas) {
		this.cantidadCarpas = cantidadCarpas;
	}
	public int getTiempoMontajeMinutos() {
		return tiempoMontajeMinutos;
	}
	public void setTiempoMontajeMinutos(int tiempoMontajeMinutos) {
		this.tiempoMontajeMinutos = tiempoMontajeMinutos;
	}


	@Override
	public String toString() {
		return "PuestoDesarmable [" + super.toString() + " cantidadCarpas=" + cantidadCarpas + ", tiempoMontajeMinutos=" + tiempoMontajeMinutos;
	}
	
	
	public BigDecimal calcularCanon(Costo costo) {

		BigDecimal totalCostoSuperficie = costo.getCostoPorSuperficie().multiply(new BigDecimal(getSuperficie()));
		BigDecimal totalCostoMontaje = costo.getDescuentoPorMontaje().multiply(new BigDecimal(getTiempoMontajeMinutos()));

		BigDecimal total = totalCostoSuperficie.subtract(totalCostoMontaje);
		
		return total;
	}
	
}
