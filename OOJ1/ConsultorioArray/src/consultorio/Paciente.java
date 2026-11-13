package consultorio;

public class Paciente {
	private String nombre;
	private String apellido;
	private float estatura;
	private float peso;
	private float IMC;
	
	public Paciente(String nombre, String apellido, float estatura, float peso, float IMC) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.estatura = estatura;
		this.peso = peso;
		this.IMC = IMC;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public float getEstatura() {
		return estatura;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public float getIMC() {
		return IMC;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public void setIMC(float IMC) {
		this.IMC = IMC;
	}
	
	public String traerNombreCompleto() {
		return nombre + ", " + apellido;
	}
	
	public boolean equals(Paciente p) {
		return ((nombre==p.getNombre())&&(apellido==p.getApellido()));
	}
	
	@Override
	public String toString() {
		return "("+nombre+", "+apellido+". "+estatura+", "+peso+", "+IMC+")";
	}
}
