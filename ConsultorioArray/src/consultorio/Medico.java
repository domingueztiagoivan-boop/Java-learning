package consultorio;

import consultorio.Paciente;

public class Medico {
	private String nombre;
	private String apellido;
	private String especialidad;
	private Paciente[] pacientesFrecuentes;
	private int capacidad;
	
	public Medico(String nombre, String apellido, String especialidad, int cantidadPacientes) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.pacientesFrecuentes = new Paciente[cantidadPacientes];
		this.capacidad = 0;
	}
	
	public String getNombre(){
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
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public void setEspecialdiad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public float calcularIMC(Paciente paciente) {
		return (paciente.getPeso() / (paciente.getEstatura() * paciente.getEstatura()));		
	}
	
	public String traerNombreCompleto() {
		return nombre + ", " + apellido;
	}
	
	public int pacientesTotal() {
		return 0;
	}
	
	public void agregarPaciente(Paciente paciente) {
		
		if (capacidad < 10) {
			pacientesFrecuentes[capacidad] = paciente;
			capacidad++;
		} else {
			System.out.print("\nArray de pacientes completo. Intente luego.");
		}
	}
	
	public void imprimirPacientesFrecuentes() {
		
		for (int i=0; i<capacidad; i++) {
			System.out.printf("  " + pacientesFrecuentes[i].toString());
			}
	}
	
	public double traerPromedioPeso(){
		
		double totalPeso = 0;	
		
		for (int i=0; i<capacidad; i++) {
			totalPeso += pacientesFrecuentes[i].getPeso();
		}
		return (totalPeso / capacidad);
	}
	
	public float traerPacienteMayorEstatura() {
		
		float mayorEstatura = 0;
		
		for (int i=0; i<capacidad; i++) {
			if (pacientesFrecuentes[i].getEstatura() > mayorEstatura) {
				mayorEstatura = pacientesFrecuentes[i].getEstatura();
			}
		}
		return mayorEstatura;
	}
	
	public float traerPacienteMenorIMC() {
		
		float menorIMC = pacientesFrecuentes[0].getIMC();
		
		for (int i=0; i<capacidad; i++) {
			if (pacientesFrecuentes[i].getIMC() < menorIMC) {
				menorIMC = pacientesFrecuentes[i].getIMC();
			}
		}
		return menorIMC;
	}
}
