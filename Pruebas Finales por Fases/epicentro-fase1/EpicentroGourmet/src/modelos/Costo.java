package modelos;
import java.math.BigDecimal;

public class Costo {
	private final int id;
	private BigDecimal sueldoBase;
	private BigDecimal costoPorSuperficie;
	private BigDecimal plusAnioAntiguedad;
	private BigDecimal descuentoPorMontaje;
	private BigDecimal plusElectricidad;
	
	public Costo(int id, BigDecimal sueldoBase, BigDecimal costoPorSuperficie, BigDecimal plusAnioAntiguedad, BigDecimal descuentoPorMontaje, BigDecimal plusElectricidad) {
		this.id = id;
		this.sueldoBase = sueldoBase;
		this.costoPorSuperficie = costoPorSuperficie;
		this.plusAnioAntiguedad = plusAnioAntiguedad;
		this.descuentoPorMontaje = descuentoPorMontaje;
		this.plusElectricidad = plusElectricidad;
		}


	public BigDecimal getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(BigDecimal sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public BigDecimal getCostoPorSuperficie() {
		return costoPorSuperficie;
	}

	public void setCostoPorSuperficie(BigDecimal costoPorSuperficie) {
		this.costoPorSuperficie = costoPorSuperficie;
	}

	public BigDecimal getPlusAnioAntiguedad() {
		return plusAnioAntiguedad;
	}

	public void setPlusAnioAntiguedad(BigDecimal plusAnioAntiguedad) {
		this.plusAnioAntiguedad = plusAnioAntiguedad;
	}

	public BigDecimal getDescuentoPorMontaje() {
		return descuentoPorMontaje;
	}

	public void setDescuentoPorMontaje(BigDecimal descuentoPorMontaje) {
		this.descuentoPorMontaje = descuentoPorMontaje;
	}

	public BigDecimal getPlusElectricidad() {
		return plusElectricidad;
	}

	public void setPlusElectricidad(BigDecimal plusElectricidad) {
		this.plusElectricidad = plusElectricidad;
	}

	public int getId(){
		return id;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Costo)) return false;
		Costo c = (Costo) obj;
		return (this.id == c.getId());
	}

	@Override
	public int hashCode(){
		return Integer.hashCode(id);
	}

	@Override
	public String toString() {
		return "Costo [sueldoBase=" + sueldoBase + ", costoPorSuperficie=" + costoPorSuperficie + ", plusAnioAntiguedad=" + plusAnioAntiguedad + ", descuentoPorMontaje=" + descuentoPorMontaje + ", plusElectricidad=" + plusElectricidad + "]";
	}
}
