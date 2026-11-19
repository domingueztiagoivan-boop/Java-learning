package modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cocinero extends Personal{
	private String especialidadCulinaria;
	private double plusCategoria;
	
	
	public Cocinero(int idPersonal, String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, String especialidadCulinaria, double plusCategoria) throws ExceptionFechaNacimiento {
		super(idPersonal, nombre, apellido, dni, fechaNacimiento, fechaIngreso);
		this.especialidadCulinaria = especialidadCulinaria;
		this.plusCategoria = plusCategoria;
	}
	
	

	public String getEspecialidadCulinaria() {
		return especialidadCulinaria;
	}
	public void setEspecialidadCulinaria(String especialidadCulinaria) {
		this.especialidadCulinaria = especialidadCulinaria;
	}
	public double getPlusCategoria() {
		return plusCategoria;
	}
	public void setPlusCategoria(double plusCategoria) {
		this.plusCategoria = plusCategoria;
	}
	
	public BigDecimal calcularSueldo(Costo costo) {
		BigDecimal total = costo.getSueldoBase().add(new BigDecimal(plusCategoria));
		return total;
	}



	@Override
	public String toString() {
		return "Cocinero [" + super.toString() + " especialidadCulinaria=" + especialidadCulinaria + ", plusCategoria=" + plusCategoria + "]";
	}
	
	
}
