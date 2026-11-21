package modelos;

import java.math.BigDecimal;
import java.util.Objects;

public class FoodTruck extends UnidadVenta{
	private final String patente;
	private final boolean requiereElectricidad;
	
	
	
	public FoodTruck(int idUnidadVenta, String nombreComercial, Personal responsable, double superficie, String codigo, String patente, boolean requiereElectricidad)throws ExceptionMenorZero{
		super(idUnidadVenta, nombreComercial, responsable, superficie, codigo);

		Objects.requireNonNull(patente, "ERROR. La patente no puede ser un atributo null.");

		this.patente = patente;
		this.requiereElectricidad = requiereElectricidad;
	}



	public String getPatente() {
		return patente;
	}
	
	public boolean isRequiereElectricidad() {
		return requiereElectricidad;
	}

	@Override
	public String toString() {
		return "FoodTruck [" + super.toString() + " patente=" + patente + ", requiereElectricidad=" + requiereElectricidad + "]";
	}
	
       
	public BigDecimal calcularCanon(Costo costo) {
		//BigDecimal t = (costo.getCostoPorSuperficie() * getSuperficie());
		BigDecimal total = costo.getCostoPorSuperficie().multiply(BigDecimal.valueOf(getSuperficie()));
		
		//double plusElectricidad = requiereElectricidad ? costo.getPlusElectricidad() : 0.0;
		BigDecimal plusElectricidad = requiereElectricidad ? costo.getPlusElectricidad() : BigDecimal.ZERO;

		BigDecimal canon = total.add(plusElectricidad);

		return canon;
	}
	
	
	
}
