package test;

import consultorio.Paciente;
import consultorio.Medico;

public class testArrayMedico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Medico medico1 = new Medico("Pablo", "Geremias", "Odontologo", 10);
		
		
		Paciente paciente1 = new Paciente("Jose", "Perez", 191f, 88f, 0f);
		Paciente paciente2 = new Paciente("Jorge", "Fernandez", 167f, 60f, 0f);
		Paciente paciente3 = new Paciente("Jose", "Perez", 173f, 69f, 0f);
		Paciente paciente4 = new Paciente("Jorge", "Fernandez", 177f, 75f, 0f);
		Paciente paciente5 = new Paciente("Jose", "Perez", 179f, 80f,0f);
		Paciente paciente6 = new Paciente("Tony", "Abduzcan", 184f, 86f, 0f);
		
		paciente1.setIMC(medico1.calcularIMC(paciente1));
		paciente2.setIMC(medico1.calcularIMC(paciente2));
		paciente3.setIMC(medico1.calcularIMC(paciente3));
		paciente4.setIMC(medico1.calcularIMC(paciente4));
		paciente5.setIMC(medico1.calcularIMC(paciente5));
		paciente6.setIMC(medico1.calcularIMC(paciente6));
		
		medico1.agregarPaciente(paciente1);
		medico1.agregarPaciente(paciente2);
		medico1.agregarPaciente(paciente3);
		medico1.agregarPaciente(paciente4);
		medico1.agregarPaciente(paciente5);
		medico1.agregarPaciente(paciente6);
		
		
		medico1.imprimirPacientesFrecuentes();
		System.out.print("\n" + medico1.traerPromedioPeso());
		System.out.print("\n" + medico1.traerPacienteMayorEstatura());
		System.out.print("\n" + medico1.traerPacienteMenorIMC());
		
		
	}

}
