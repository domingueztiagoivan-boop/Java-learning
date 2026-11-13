package Modelos;

import java.time.LocalDate;

public abstract class Persona {
		protected String nombre;
		protected String apellido;
		protected long dni;
		protected LocalDate fechaNacimiento;
		
		public Persona(String nombre, String apellido, long dni, LocalDate fechaNacimiento) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.fechaNacimiento = fechaNacimiento;
		}
		
		
		public String getNombre() {
			return this.nombre;
		}
		
		public String getApellido() {
			return this.apellido;
		}
		
		public long getDni() {
			return this.dni;
		}
		
		public LocalDate getFechaNacimiento() {
			return this.fechaNacimiento;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		
		public void setDni(long dni){
			this.dni = dni;
		}
		
		public void setFechaNacimiento(LocalDate fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}
		
		
		public int calculaEdad() {
			
			int anioNacimiento = fechaNacimiento.getYear();
			int edad = 0;
			
			while (anioNacimiento < LocalDate.now().getYear()) {
				edad += 1;
				anioNacimiento++;
			}
			
			return edad;
		}
		
		public String hablar() {
		return "Soy persona";
		}

		@Override
		public String toString() {
			return "[Nombre: " + this.nombre + " Apellido: " + this.apellido + " Dni: " + this.dni + " Fecha Nacimiento: " + this.fechaNacimiento +"]";
		}
		
		public boolean equals(Persona persona) {
			return (persona.getDni() == this.dni);
		}
		
		
}
