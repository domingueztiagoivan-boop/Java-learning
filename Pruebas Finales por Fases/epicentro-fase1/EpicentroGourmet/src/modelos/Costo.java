package modelos;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Costo {
	private final int id;
	private BigDecimal sueldoBase;
	private BigDecimal costoPorSuperficie;
	private BigDecimal plusAnioAntiguedad;
	private BigDecimal descuentoPorMontaje;
	private BigDecimal plusElectricidad;

	
	public Costo(int id, BigDecimal sueldoBase, BigDecimal costoPorSuperficie, BigDecimal plusAnioAntiguedad, BigDecimal descuentoPorMontaje, BigDecimal plusElectricidad)throws ExceptionMenorZero {
		Objects.requireNonNull(sueldoBase, "ERROR. El sueldo base no puede ser un atributo null.");
		Objects.requireNonNull(costoPorSuperficie, "ERROR. El costo superficie no puede ser un atributo null.");
		Objects.requireNonNull(plusAnioAntiguedad, "ERROR. El plus antiguedad no puede ser un atributo null.");
		Objects.requireNonNull(descuentoPorMontaje, "ERROR. El descuento por montaje no puede ser un atributo null.");
		Objects.requireNonNull(plusElectricidad, "ERROR. El plus electricidad no puede ser un atributo null.");
		this.id = validarId(id);
		setSueldoBase(sueldoBase);
		setCostoPorSuperficie(costoPorSuperficie);
		setPlusAnioAntiguedad(plusAnioAntiguedad);
		setDescuentoPorMontaje(descuentoPorMontaje);
		setPlusElectricidad(plusElectricidad);
		}


	public BigDecimal getSueldoBase(){
		return sueldoBase;
	}

	public void setSueldoBase(BigDecimal sueldoBase)throws ExceptionMenorZero {
		if (sueldoBase.compareTo(BigDecimal.ZERO) <= 0) throw new ExceptionMenorZero("ERROR. El sueldo base debe ser mayor a 0.");
		this.sueldoBase = sueldoBase;
	}

	public BigDecimal getCostoPorSuperficie() {
		return costoPorSuperficie.setScale(2, RoundingMode.HALF_UP);
	}

	public void setCostoPorSuperficie(BigDecimal costoPorSuperficie) throws ExceptionMenorZero{
		if (costoPorSuperficie.compareTo(BigDecimal.ZERO) < 0) throw new ExceptionMenorZero("ERROR. El costo superficie debe ser mayor a 0.");
		this.costoPorSuperficie = costoPorSuperficie;
	}

	public BigDecimal getPlusAnioAntiguedad() {
		return plusAnioAntiguedad.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPlusAnioAntiguedad(BigDecimal plusAnioAntiguedad)throws ExceptionMenorZero {
		if (plusAnioAntiguedad.compareTo(BigDecimal.ZERO) < 0) throw new ExceptionMenorZero("ERROR. El Plus de antiguedad debe ser mayor a 0.");
		this.plusAnioAntiguedad = plusAnioAntiguedad;
	}

	public BigDecimal getDescuentoPorMontaje() {
		return descuentoPorMontaje.setScale(2, RoundingMode.HALF_UP);
	}

	public void setDescuentoPorMontaje(BigDecimal descuentoPorMontaje)throws ExceptionMenorZero {
		if (descuentoPorMontaje.compareTo(BigDecimal.ZERO) < 0) throw new ExceptionMenorZero("ERROR. El descuento debe ser mayor a 0.");
		this.descuentoPorMontaje = descuentoPorMontaje;
	}

	public BigDecimal getPlusElectricidad() {
		return plusElectricidad.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPlusElectricidad(BigDecimal plusElectricidad) throws ExceptionMenorZero{
		if (plusElectricidad.compareTo(BigDecimal.ZERO) < 0)throw new ExceptionMenorZero("ERROR. El plus debe ser mayor a 0.");
		this.plusElectricidad = plusElectricidad;
	}

	public int getId(){
		return id;
	}

	private static int validarId(int id)throws ExceptionMenorZero{
		if (id < 0)throw new ExceptionMenorZero("ERROR. El id debe ser mayor o igual a 0.");
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
