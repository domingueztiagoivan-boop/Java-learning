package test;

import consultorio.Paciente;
import consultorio.Medico;



public class TestConsultorio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Medico medico1 = new Medico("Daniel", "Lopez", "Matematico");
		Paciente paciente2 = new Paciente("Jose", "Perez", 0f, 0f, 26.23457f);
		Paciente paciente3 = new Paciente("Jorge", "Fernandez", 0f, 0f, 35.156246f);
		
		paciente2.setEstatura(1.56f);
		paciente2.setPeso(55f);
		float nuevoIMC = medico1.calcularIMC(paciente2);
		paciente2.setIMC(nuevoIMC);
		
		paciente3.setEstatura(1.82f);
		paciente3.setPeso(75f);
		float nuevoIMC2 = medico1.calcularIMC(paciente3);
		paciente3.setIMC(nuevoIMC2);
		
		
		
		
		System.out.print("Medico" + ": " + medico1.traerNombreCompleto() + "\n");
		System.out.print("Paciente" + ": "+ paciente2.traerNombreCompleto() + " IMC: " + paciente2.getIMC() + "\n");
		System.out.print("Paciente" + ": " + paciente3.traerNombreCompleto() + " IMC: " + paciente3.getIMC() + "\n");
	}

}
