package test;

import consultorio.Medico;
import consultorio.Paciente;

public class TestMetodosToStringYEquual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Paciente paciente1 = new Paciente("Akira", "Dominguez", 40f, 3.5f, 40.1235123f);
		Paciente paciente2 = new Paciente("Jose", "Perez", 0f, 0f, 26.23457f);
		Paciente paciente3 = new Paciente("Jorge", "Fernandez", 0f, 0f, 35.156246f);
		Paciente paciente4 = new Paciente("Akira", "Dominguez", 40f, 3.5f, 40.1235123f);
		
		
		System.out.print(paciente1.toString());
		System.out.print("\n\n" + "Paciente" + ": " + paciente3.traerNombreCompleto() + " IMC: " + paciente3.getIMC() + "\n");
		System.out.print(paciente1.equals(paciente3));
		System.out.print("\n" + paciente1.equals(paciente4));

	}

}
