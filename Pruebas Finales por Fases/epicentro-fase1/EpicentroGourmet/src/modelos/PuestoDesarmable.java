package modelos;

import java.math.BigDecimal;

public class PuestoDesarmable extends UnidadVenta{
	private int cantidadCarpas;
	private int tiempoMontajeMinutos;
	
	
	public PuestoDesarmable(int idUnidadVenta, String nombreComercial, Personal responsable, double superficie, String codigo, int cantidadCarpas, int tiempoMontajeMinutos)throws ExceptionMenorZero {
	
		super(idUnidadVenta, nombreComercial, responsable, superficie, codigo);
		this.cantidadCarpas = validarCantidadCarpas(cantidadCarpas);
		this.tiempoMontajeMinutos = validarTiempoMontaje(tiempoMontajeMinutos);
	}


	public int getCantidadCarpas() {
		return cantidadCarpas;
	}
	public void setCantidadCarpas(int cantidadCarpas) throws ExceptionMenorZero{
		this.cantidadCarpas = validarCantidadCarpas(cantidadCarpas);
	}
	public int getTiempoMontajeMinutos() {
		return tiempoMontajeMinutos;
	}
	public void setTiempoMontajeMinutos(int tiempoMontajeMinutos) throws ExceptionMenorZero{
		this.tiempoMontajeMinutos = validarTiempoMontaje(tiempoMontajeMinutos);
	}


	private static int validarTiempoMontaje(int tiempoMontajeMinutos) throws ExceptionMenorZero{
		if (tiempoMontajeMinutos < 0) throw new ExceptionMenorZero("ERROR. El tiempo de montaje no puede valer 0.");
		return tiempoMontajeMinutos;
	}

	private static int validarCantidadCarpas(int cantidadCarpas) throws ExceptionMenorZero{
		if (cantidadCarpas < 0) throw new ExceptionMenorZero("ERROR. La cantidad de carpas no puede valer 0.");
		return cantidadCarpas;
	}

	@Override
	public String toString() {
		return "PuestoDesarmable [" + super.toString() + " cantidadCarpas=" + cantidadCarpas + ", tiempoMontajeMinutos=" + tiempoMontajeMinutos;
	}
	
	
	public BigDecimal calcularCanon(Costo costo) {

		BigDecimal totalCostoSuperficie = costo.getCostoPorSuperficie().multiply(BigDecimal.valueOf((getSuperficie())));
		BigDecimal totalCostoMontaje = costo.getDescuentoPorMontaje().multiply(BigDecimal.valueOf((getTiempoMontajeMinutos())));

		BigDecimal total = totalCostoSuperficie.subtract(totalCostoMontaje);
		
		return total;
	}
	
}
