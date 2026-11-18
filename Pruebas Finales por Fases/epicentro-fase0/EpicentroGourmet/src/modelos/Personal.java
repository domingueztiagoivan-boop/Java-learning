package modelos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Personal {
		protected int idPersonal;
		protected String nombre;
		protected String apellido;
		protected long dni;
		protected LocalDate fechaNacimiento;
		protected LocalDate fechaIngreso;
		
		
		public Personal(int idPersonal, String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
			this.idPersonal = idPersonal;
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.fechaNacimiento = fechaNacimiento;
			this.fechaIngreso = fechaIngreso;
		}


		public int getIdPersonal() {
			return idPersonal;
		}
		public void setIdPersonal(int idPersonal) {
			this.idPersonal = idPersonal;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public long getDni() {
			return dni;
		}
		public void setDni(long dni) {
			this.dni = dni;
		}
		public LocalDate getFechaNacimiento() {
			return fechaNacimiento;
		}
		public void setFechaNacimiento(LocalDate fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}
		public LocalDate getFechaIngreso() {
			return fechaIngreso;
		}
		public void setFechaIngreso(LocalDate fechaIngreso) {
			this.fechaIngreso = fechaIngreso;
		}


		@Override
		public String toString() {
			return " idPersonal=" + idPersonal + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso;
		}
		
		public boolean equals(Personal personal) {
			return (personal.getDni() == this.dni);
		}
		
		abstract double calcularSueldo(Costo costo);

	   
	    public int calcularAntiguedad() {
	        return (int) ChronoUnit.YEARS.between(this.fechaIngreso, LocalDate.now());
	    }
		
}
