package modelos;

public class Costo {
	private double sueldoBase;
	private double costoPorSuperficie;
	private double plusAnioAntiguedad;
	private double descuentoPorMontaje;
	private double plusElectricidad;
	
	public Costo(double sueldoBase, double costoPorSuperficie, double plusAnioAntiguedad, double descuentoPorMontaje, double plusElectricidad) {
		this.sueldoBase = sueldoBase;
		this.costoPorSuperficie = costoPorSuperficie;
		this.plusAnioAntiguedad = plusAnioAntiguedad;
		this.descuentoPorMontaje = descuentoPorMontaje;
		this.plusElectricidad = plusElectricidad;
		}

	public double getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	public double getCostoPorSuperficie() {
		return costoPorSuperficie;
	}
	public void setCostoPorSuperficie(double costoPorSuperficie) {
		this.costoPorSuperficie = costoPorSuperficie;
	}
	public double getPlusAnioAntiguedad() {
		return plusAnioAntiguedad;
	}
	public void setPlusAnioAntiguedad(double plusAnioAntiguedad) {
		this.plusAnioAntiguedad = plusAnioAntiguedad;
	}
	public double getDescuentoPorMontaje() {
		return descuentoPorMontaje;
	}
	public void setDescuentoPorMontaje(double descuentoPorMontaje) {
		this.descuentoPorMontaje = descuentoPorMontaje;
	}
	public double getPlusElectricidad() {
		return plusElectricidad;
	}
	public void setPlusElectricidad(double plusElectricidad) {
		this.plusElectricidad = plusElectricidad;
	}
	
	
	public boolean equals(Costo costo) {
		return (costo.sueldoBase == this.sueldoBase && costo.costoPorSuperficie == this.costoPorSuperficie && costo.descuentoPorMontaje == this.descuentoPorMontaje && costo.plusAnioAntiguedad == this.plusAnioAntiguedad); 
	}

	@Override
	public String toString() {
		return "Costo [sueldoBase=" + sueldoBase + ", costoPorSuperficie=" + costoPorSuperficie + ", plusAnioAntiguedad=" + plusAnioAntiguedad + ", descuentoPorMontaje=" + descuentoPorMontaje + ", plusElectricidad=" + plusElectricidad + "]";
	}
	
	
}
