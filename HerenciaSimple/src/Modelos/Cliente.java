package Modelos;

import java.time.LocalDate;


public class Cliente extends Persona {
		private String cuit;
		private float limiteCredito;
		
		
		
		public Cliente(String nombre, String apellido, long dni, LocalDate fechaNacimiento, String cuit, float limiteCredito) {
			
			super(nombre, apellido, dni, fechaNacimiento);
			this.cuit = cuit;
			this.limiteCredito = limiteCredito;
		}
		
		
		public float getLimiteCredito() {
			return this.limiteCredito;
		}
		
		public void setLimiteCredito(float limiteCredito) {
			this.limiteCredito = limiteCredito;
		}
		
		public String getCuit() {
			return this.cuit;
		}
		
		public void setCuit(String cuit) {
			this.cuit = cuit;
		}
		
		
		public String estadoCredito() {
			String estado;
		    
		    if (this.limiteCredito <= 0) {
		        estado = "Crédito Suspendido / Sin Fondos";
		    } else if (this.limiteCredito < 50000) {
		        estado = "Crédito Inicial / Bajo Riesgo";
		    } else if (this.limiteCredito < 200000) {
		        estado = "Crédito Moderado / Cliente Activo";
		    } else {
		        estado = "Crédito Premium / Excelente Historial";
		    }
		    
		    return estado;
		}
		
		
		public String hablar() {
			return "Soy Cliente";
		}
		
		@Override
		public String toString() {
			return super.toString() + " Cuit: " + this.cuit + " Limite Credito: " + limiteCredito + "]";
		}
		
		
		public boolean equals(Cliente cliente) {
			return (cliente.getCuit() == this.cuit);
		}
		
		
}		


