package modelos;

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
	
	
	public double calcularCanon(Costo costo) {
		double total = (getSuperficie() * costo.getCostoPorSuperficie()) - (getTiempoMontajeMinutos() * costo.getDescuentoPorMontaje());
		
		return total;
	}
	
}
