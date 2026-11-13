package modelo;

public class Cliente {
		private int idCliente;
		private String nombre;
		private String apellido;
		private long dni;
		private String telefono;
		
		
		
		public Cliente(String nombre, String apellido, long dni, String telefono, int idCliente) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.telefono = telefono;
			this.idCliente = idCliente;
		}
		
		
		
		
		
		
		
		public int getIdCliente() {
			return idCliente;
		}
		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public long getDni() {
			return dni;
		}
		public void setDni(long dni) {
			this.dni = dni;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
		@Override
		public String toString() {
			return "[ID: " + this.idCliente + " Nombre: " + this.nombre + " Apellido: " + this.apellido + " Dni: " + this.dni + " Telefono: " + this.telefono + "]";
		}
		
		public boolean equals(Cliente cliente) {
			return (cliente.getDni() == this.dni);
		}
		
}
