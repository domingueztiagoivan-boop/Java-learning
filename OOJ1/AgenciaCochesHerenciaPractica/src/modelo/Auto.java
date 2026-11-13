package modelo;

public class Auto extends Vehiculo {
		private boolean esHibrido;
		
		
		
		public Auto(String patente, int capacidadPasajeros, int idVehiculo,  boolean esHibrido) {
			super(patente, capacidadPasajeros, idVehiculo);
			this.esHibrido = esHibrido;
		}



		public boolean isEsHibrido() {
			return esHibrido;
		}
		public void setEsHibrido(boolean esHibrido) {
			this.esHibrido = esHibrido;
		}
		
		@Override
		public String toString() {
			return super.toString() + "[Hibrido: " + this.esHibrido + "]";
		}
		
		public String hablar() {
			return "Soy auto";
		}
}
