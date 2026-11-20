package modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Cocinero extends Personal{
	private String especialidadCulinaria;
	private BigDecimal plusCategoria;
	
	
	public Cocinero(int idPersonal, String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, String especialidadCulinaria, BigDecimal plusCategoria) throws ExceptionFechaNacimiento, ExceptionMenorZero {
			Objects.requireNonNull(especialidadCulinaria, ("ERROR. La especialidad culinaria no puede ser parametro null."));
			Objects.requireNonNull(plusCategoria, ("ERROR. El plus de categoria no puede ser parametro null."));
		super(idPersonal, nombre, apellido, dni, fechaNacimiento, fechaIngreso);
		this.especialidadCulinaria = especialidadCulinaria;
		setPlusCategoria(plusCategoria);
	}
	
	

	public String getEspecialidadCulinaria() {
		return especialidadCulinaria;
	}
	public void setEspecialidadCulinaria(String especialidadCulinaria) {
		this.especialidadCulinaria = especialidadCulinaria;
	}
	public BigDecimal getPlusCategoria() {
		return plusCategoria;
	}
	public void setPlusCategoria(BigDecimal plusCategoria) throws ExceptionMenorZero{
		if (plusCategoria.compareTo(BigDecimal.ZERO) < 0) throw new ExceptionMenorZero("ERROR. El plus categoria debe ser mayor a 0.");

		this.plusCategoria = plusCategoria;
	}
	


	public BigDecimal calcularSueldo(Costo costo) {
		BigDecimal total = costo.getSueldoBase().add(plusCategoria);
		return total;
	}



	@Override
	public String toString() {
		return "Cocinero [" + super.toString() + " especialidadCulinaria=" + especialidadCulinaria + ", plusCategoria=" + plusCategoria + "]";
	}
	
	
}
