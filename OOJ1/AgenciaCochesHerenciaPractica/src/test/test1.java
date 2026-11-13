package test;

import java.time.LocalDate;
import java.util.List;

import modelo.Auto;
import modelo.Camioneta;
import modelo.Cliente;
import modelo.Reserva;
import modelo.Vehiculo;
import modelo.SistemaAgencia;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SistemaAgencia agencia = new SistemaAgencia();
		
		
		System.out.println("1) Agregar Clientes:");
        try {
            agencia.agregarCliente("Juan", "Perez", 38958345L, "+541146592131");
            agencia.agregarCliente("Mario", "Lopez", 32964234L, "+541163927564");
            System.out.println("-> Clientes agregados con éxito.");
		
        } catch (Exception e) {
        	System.out.println(e.getMessage()); 
        }
        
        System.out.println("\n2) Agregar Vehículos (Herencia - Autos y Camionetas):");
        try {
        	agencia.agregarAuto("AA111BB", 5, true);
        	agencia.agregarCamioneta("BB222CC", 3, 1200);
        	System.out.println("-> Vehículos registrados.");
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        
        System.out.println("\n3) Intentar agregar reserva exitosa:");
        try {
        	agencia.agregarReserva(agencia.traerCliente(38958345L), LocalDate.of(2026, 05, 23), agencia.traerVehiculo("AA111BB"), 4);
        	agencia.agregarReserva(agencia.traerCliente(32964234L), LocalDate.of(2026, 05, 20), agencia.traerVehiculo("BB222CC"), 3);
        	System.out.println("-> Reserva 1 creada con éxito.");
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        
        System.out.println("\n4) Test Excepción: Pasajeros exceden capacidad del Vehículo:");
        try {
        	agencia.agregarReserva(agencia.traerCliente(32964234L), LocalDate.of(2026, 05, 22), agencia.traerVehiculo("BB222CC"), 5);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        
        System.out.println("\n5) Test Excepción: Vehículo duplicado en la misma fecha:");
        try {
        	agencia.agregarReserva(agencia.traerCliente(38958345L), LocalDate.of(2026, 05, 23), agencia.traerVehiculo("AA111BB"), 4);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        
        System.out.println("\n6) Traer Vehículos Libres para el 2026-05-21:");
         
        for (Vehiculo v: agencia.traerVehiculosLibresPorFecha(LocalDate.of(2026, 05, 21))) {
        	System.out.println(v.toString());
        }
        
        System.out.println("\n7) Funcion hablar Abstracta de Vehiculo:");
        
        for (Vehiculo v: agencia.getLstVehiculos()) {
        	System.out.println(v.hablar());
        }
        
	}
}
