package modelo;

public class Camioneta extends Vehiculo{
		private int cargaMaxKg;
		
		
		
		public Camioneta(String patente, int capacidadPasajeros, int idVehiculo,  int cargaMaxKg) {
			super(patente, capacidadPasajeros, idVehiculo);
			this.cargaMaxKg = cargaMaxKg;
		}



		public int getCargaMaxKg() {
			return cargaMaxKg;
		}
		public void setCargaMaxKg(int cargaMaxKg) {
			this.cargaMaxKg = cargaMaxKg;
		}
		
		
		@Override
		public String toString() {
			return super.toString() + "[Carga Maxima: " + this.cargaMaxKg + "]";
		}
		
		public String hablar() {
			return "Soy camioneta";
		}
		
}
