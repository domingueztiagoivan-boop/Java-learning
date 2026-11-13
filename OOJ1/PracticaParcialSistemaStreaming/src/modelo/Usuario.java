package modelo;

public class Usuario {
	private int idUsuario;
	private String nombre;
	private String email;
	private boolean esPremium;
	
	
	
	public Usuario(int idUsuario, String nombre, String email, boolean esPremium) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.email = email;
		this.esPremium = esPremium;
	}



	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getEsPremium() {
		return esPremium;
	}
	public void setEsPremium(boolean esPremium) {
		this.esPremium = esPremium;
	}
	
	
	
	
	@Override
	public String toString() {
		return "[ID: " + this.idUsuario + " Nombre: " + this.nombre + " Email: " + this.email + " Premium: " + this.esPremium + "]";
	}
	
	public boolean equals(Usuario usuario) {
		return (usuario.getIdUsuario() == this.idUsuario);
	}
	
	
}
