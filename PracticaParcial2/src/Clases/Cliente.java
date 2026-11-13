package Clases;

public class Cliente {
		private int idCliente;
		private String nombre;
		private String apellido;
		private String telefono;
		private int dni;
		
		
		public Cliente(String nombre, String apellido, String telefono, int dni) {
			this.nombre  = nombre;
			this.apellido = apellido;
			this.telefono = telefono;
			this.dni = dni;
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


		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
		public int getDni() {
			return this.dni;
		}
		
		public void setDni(int dni) {
			this.dni = dni;
		}
		
		@Override
		
		public String toString() {
			return "[Nombre: " + this.nombre + " Apellido: " + this.apellido + " Dni: " + this.dni + " Telefono: " + this.telefono + " Id: " + this.idCliente + "]";
		}
		
		public boolean equalsCliente(Cliente cliente) {
			return (this.dni == cliente.getDni());
		}
}
