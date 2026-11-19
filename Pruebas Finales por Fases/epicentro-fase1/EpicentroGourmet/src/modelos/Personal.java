package modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Objects;	

public abstract class Personal {
		protected final int idPersonal;
		protected final String nombre;
		protected final String apellido;
		protected final long dni;
		protected final LocalDate fechaNacimiento;
		protected final LocalDate fechaIngreso;
		
		
		public Personal(int idPersonal, String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso) throws ExceptionFechaNacimiento {
			this.idPersonal = idPersonal;
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.fechaNacimiento = validarFechaNacimiento(fechaNacimiento);
			this.fechaIngreso = fechaIngreso;
		}


		public int getIdPersonal() {
			return idPersonal;
		}
		
		public String getNombre() {
			return nombre;
		}
		
		public String getApellido() {
			return apellido;
		}
		
		public long getDni() {
			return dni;
		}
		
		public LocalDate getFechaNacimiento() {
			return fechaNacimiento;
		}
		
		public LocalDate getFechaIngreso() {
			return fechaIngreso;
		}
		


		@Override
		public boolean equals(Object obj){
			if (this == obj) return true;
			if (!(obj instanceof Personal)) return false;
			Personal p = (Personal) obj;
			return (this.dni == p.getDni());
		}


		@Override
		public int hashCode(){
			return Long.hashCode(dni);
		}


		@Override
		public String toString() {
			return " idPersonal=" + idPersonal + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso;
		}
		
		
		abstract BigDecimal calcularSueldo(Costo costo);

	   
	    public int calcularAntiguedad() {
	        return (int) ChronoUnit.YEARS.between(this.fechaIngreso, LocalDate.now());
	    }
		
		public LocalDate validarFechaNacimiento(LocalDate fechaNacimiento) throws ExceptionFechaNacimiento{
			Objects.requireNonNull(fechaNacimiento, "ERROR. La fecha de nacimiento no puede ser nula.");

			int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();

			if (edad < 18) throw new ExceptionFechaNacimiento("El personal debe ser mayor de 18 años (Edad actual: " + edad + ")");
			return  fechaNacimiento;
		}
}
