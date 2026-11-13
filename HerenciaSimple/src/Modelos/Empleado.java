package Modelos;

import java.time.LocalDate;

public class Empleado extends Persona{
		private long legajo;
		private float sueldoMensual;
		
		
		
		public Empleado(String nombre, String apellido, long dni, LocalDate fechaNacimiento, long legajo, float sueldoMensual) {
			super(nombre, apellido, dni, fechaNacimiento);
			this.legajo = legajo;
			this.sueldoMensual = sueldoMensual;
		}
		
		
		public long getLegajo() {
			return this.legajo;
		}
		
		public void setLegajo(long legajo) {
			this.legajo = legajo;
		}
		
		public float getSueldoMensual() {
			return this.sueldoMensual;
		}
		
		public void setSueldoMensual(float sueldoMensual) {
			this.sueldoMensual = sueldoMensual;
		}
		
		public float calcularSueldo(int diasAusentes) {
			float sueldoXDia = sueldoMensual / 30;
			float sueldoNuevo = sueldoMensual;
			
			if (diasAusentes != 0) {
				for (int i=0; i<diasAusentes; i++) {
						sueldoNuevo -= sueldoXDia;
				}
			}
			
			return sueldoNuevo;
		}
		
		
		
		public String hablar() {
			return "Soy empleado";
		}
		
		@Override
		public String toString() {
			return super.toString() +  " Legajo: " + this.legajo + " Sueldo Mensual: " + this.sueldoMensual + "]";
		}
		
		public boolean equals(Empleado empleado) {
			return (empleado.getLegajo() == this.legajo);
		}
		
}
