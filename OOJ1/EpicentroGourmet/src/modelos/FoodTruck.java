package modelos;

public class FoodTruck extends UnidadVenta{
	private String patente;
	private boolean requiereElectricidad;
	
	
	
	public FoodTruck(int idUnidadVenta, String nombreComercial, Personal responsable, double superficie, String codigo, String patente, boolean requiereElectricidad) {
		super(idUnidadVenta, nombreComercial, responsable, superficie, codigo);
		this.patente = patente;
		this.requiereElectricidad = requiereElectricidad;
	}



	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public boolean isRequiereElectricidad() {
		return requiereElectricidad;
	}
	public void setRequiereElectricidad(boolean requiereElectricidad) {
		this.requiereElectricidad = requiereElectricidad;
	}


	@Override
	public String toString() {
		return "FoodTruck [" + super.toString() + " patente=" + patente + ", requiereElectricidad=" + requiereElectricidad + "]";
	}
	

	public double calcularCanon(Costo costo) {
		double total = (costo.getCostoPorSuperficie() * getSuperficie());
		
		double plusElectricidad = requiereElectricidad ? costo.getPlusElectricidad() : 0.0;
		
		return (total + plusElectricidad);
	}
	
	
	
}
