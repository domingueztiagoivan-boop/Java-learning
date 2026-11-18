package modelos;

import java.time.LocalDate;

public class Cajero extends Personal{
		private String turnoTrabajo;
		
		public Cajero(int idPersonal, String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, String turnoTrabajo) {
			super(idPersonal, nombre, apellido, dni, fechaNacimiento, fechaIngreso);
			this.turnoTrabajo = turnoTrabajo;
		}

		
		public String getTurnoTrabajo() {
			return turnoTrabajo;
		}
		public void setTurnoTrabajo(String turnoTrabajo) {
			this.turnoTrabajo = turnoTrabajo;
		}
		
		
		public double calcularSueldo(Costo costo) {
			return (costo.getSueldoBase() + (costo.getPlusAnioAntiguedad() * calcularAntiguedad()));
		}


		@Override
		public String toString() {
			return "Cajero [" + super.toString() + " turnoTrabajo=" + turnoTrabajo + "]";
		}
		
		
		
}	

