package test;


import consultorio.Paciente;
import consultorio.Medico;

public class TestConsultorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Hola mundo :)"); 
		
		Paciente paciente1 = new Paciente("Akira", "Dominguez", 40f, 3.5f, 40.1235123f);
		String nombreCompleto = paciente1.traerNombreCompleto();
		System.out.print("\n" +  nombreCompleto);
		System.out.print("\n\n\n");
		
		Medico medico1 = new Medico("Daniel", "Lopez", "Matematico");
		Paciente paciente2 = new Paciente("Jose", "Perez", 0f, 0f, 26.23457f);
		Paciente paciente3 = new Paciente("Jorge", "Fernandez", 0f, 0f, 35.156246f);
		
		
		System.out.print("Medico" + ": " + medico1.traerNombreCompleto() + "\n");
		System.out.print("Paciente" + ": "+ paciente2.traerNombreCompleto() + " IMC: " + paciente2.getIMC() + "\n");
		System.out.print("Paciente" + ": " + paciente3.traerNombreCompleto() + " IMC: " + paciente3.getIMC() + "\n");
		
		
		
	}
	
	
}
