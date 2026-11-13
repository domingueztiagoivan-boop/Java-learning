package Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import Modelos.Cliente;
import Modelos.Empleado;
import Modelos.Persona;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("1) Instanciar objetos");
        // Recordá que no podés hacer new Persona() porque es abstracta.
        // Pero sí podés crear Empleados y Clientes.
        
        Empleado emp1 = new Empleado("Carlos", "Gomez", 30123456L, LocalDate.of(1985, 5, 20), 1001L, 600000f);
        Cliente cli1 = new Cliente("Ana", "Martínez", 40987654L, LocalDate.of(1998, 10, 15), "27-40987654-3", 150000f);
        
        System.out.println("\n2) Probar toString de cada uno");
        System.out.println(emp1); 
        System.out.println(cli1); 
        
        System.out.println("\n3) Probar métodos específicos");
        System.out.println("Edad del Carlos: " + emp1.calculaEdad() + " y la edad de ana: " + cli1.calculaEdad());
        System.out.println("Sueldo final de " + emp1.getNombre() + " con 3 ausencias: $" + emp1.calcularSueldo(3));
        System.out.println("Estado crediticio de " + cli1.getNombre() + ": " + cli1.estadoCredito());
        
        System.out.println("\n4) Magia de la Herencia: Lista de Personas y Polimorfismo");
        // Armamos una lista de la clase PADRE
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(emp1);
        listaPersonas.add(cli1);
        
    
        for (Persona p : listaPersonas) {
            System.out.println(p.getNombre() + " dice: " + p.hablar());
        }
			
        
		

	}

}
