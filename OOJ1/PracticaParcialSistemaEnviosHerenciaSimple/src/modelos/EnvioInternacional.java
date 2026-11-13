package modelos;

public class EnvioInternacional extends Envio{
		private String paisDestino;
		private boolean pagaAduana;
		
		
		
		
		public EnvioInternacional(int idEnvio, Cliente cliente, Camion camion, double pesoPaqueteKg, int distanciaKm, String paisDestino, boolean pagaAduana) throws Exception{
			super(idEnvio, cliente, camion, pesoPaqueteKg, distanciaKm);
			this.paisDestino = paisDestino;
			this.pagaAduana = pagaAduana; 
		}




		public String getPaisDestino() {
			return paisDestino;
		}
		public void setPaisDestino(String paisDestino) {
			this.paisDestino = paisDestino;
		}
		public boolean getPagaAduana() {
			return pagaAduana;
		}
		public void setPagaAduana(boolean pagaAduana) {
			this.pagaAduana = pagaAduana;
		}
		
		@Override
		public String toString() {
			return super.toString() + " [PaisDestino: " + this.paisDestino + " PagaAduana: " + this.pagaAduana + "]";
		}
}


