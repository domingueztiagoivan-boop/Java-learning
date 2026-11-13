package modelos;

public class Cliente {
		private int idClietnte;
		private String nombre;
		private long cuit;
		
		
		
		public Cliente(int idCliente, String nombre, long cuit) {
			this.idClietnte = idCliente;
			this.nombre = nombre;
			this.cuit = cuit;
		}



		public int getIdClietnte() {
			return idClietnte;
		}
		public void setIdClietnte(int idClietnte) {
			this.idClietnte = idClietnte;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public long getCuit() {
			return cuit;
		}
		public void setCuit(long cuit) {
			this.cuit = cuit;
		}
		
		
		@Override
		public String toString() {
			return "[Id: " + this.idClietnte + " Nombre: " + this.nombre + " Cuit: " + this.cuit + "]";
		}
		
		public boolean equals(Cliente cliente) {
			return (cliente.getIdClietnte() == this.idClietnte);
		}
		
		
}
