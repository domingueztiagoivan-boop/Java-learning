package modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Cajero extends Personal{
		private Turno turnoTrabajo;
		
		public Cajero(int idPersonal, String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, Turno turnoTrabajo) throws ExceptionFechaNacimiento, ExceptionMenorZero {
			Objects.requireNonNull(turnoTrabajo, ("ERROR. El turno trabajo no puede ser parametro null."));
			super(idPersonal, nombre, apellido, dni, fechaNacimiento, fechaIngreso);
			this.turnoTrabajo = turnoTrabajo;
		}

		
		public Turno getTurnoTrabajo() {
			return turnoTrabajo;
		}
		//Setter se queda por si hay un ajuste de horarios en el sistema con los trabajadores.
		public void setTurnoTrabajo(Turno turnoTrabajo) {
			Objects.requireNonNull(turnoTrabajo, ("ERROR. El turno trabajo no puede ser parametro null."));
			this.turnoTrabajo = turnoTrabajo;
		}
		
		public BigDecimal calcularSueldo(Costo costo) {
			
			BigDecimal totalAntiguedad = costo.getPlusAnioAntiguedad().multiply(new BigDecimal(calcularAntiguedad()));
			BigDecimal total = costo.getSueldoBase().add(totalAntiguedad);
			return total;
		}


		@Override
		public String toString() {
			return "Cajero [" + super.toString() + " turnoTrabajo=" + turnoTrabajo.getDescripcion() + "]";
		}
		
		
		
}	

