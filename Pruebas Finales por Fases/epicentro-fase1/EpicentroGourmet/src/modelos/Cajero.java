package modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cajero extends Personal{
		private String turnoTrabajo;
		
		public Cajero(int idPersonal, String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, String turnoTrabajo) throws ExceptionFechaNacimiento {
			super(idPersonal, nombre, apellido, dni, fechaNacimiento, fechaIngreso);
			this.turnoTrabajo = turnoTrabajo;
		}

		
		public String getTurnoTrabajo() {
			return turnoTrabajo;
		}
		public void setTurnoTrabajo(String turnoTrabajo) {
			this.turnoTrabajo = turnoTrabajo;
		}
		
		
		public BigDecimal calcularSueldo(Costo costo) {
			
			BigDecimal totalAntiguedad = costo.getPlusAnioAntiguedad().multiply(new BigDecimal(calcularAntiguedad()));
			BigDecimal total = costo.getSueldoBase().add(totalAntiguedad);
			return total;
		}


		@Override
		public String toString() {
			return "Cajero [" + super.toString() + " turnoTrabajo=" + turnoTrabajo + "]";
		}
		
		
		
}	

