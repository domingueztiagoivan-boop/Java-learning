package test;

import java.time.LocalDate;
import java.util.List;

import modelos.*;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();
		
		try {
			sistema.agregarMesa(4, 10);
			sistema.agregarMesa(4, 11);
			sistema.agregarMesa(4, 12);
			sistema.agregarMesa(5, 20);
			sistema.agregarMesa(5, 21);
			sistema.agregarMesa(5, 22);
			System.out.println(sistema.getLstMesas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			sistema.agregarRepartidorMoto("MOT111", 2, 300, 95);
			sistema.agregarRepartidorMoto("MOT222", 5, 550, 130);
			sistema.agregarRepartidorCiclista("CIC123", 4, false, 2000);
			sistema.agregarRepartidorCiclista("CIC456", 8, true, 3500);
			System.out.println(sistema.getLstRepartidores());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			sistema.agregarEnvio(LocalDate.of(2026, 05, 15), sistema.traerMesa(4, 10), sistema.traerRepartidor("MOT222"), 4, 25);
			sistema.agregarEnvio(LocalDate.of(2026, 05, 12), sistema.traerMesa(4, 11), sistema.traerRepartidor("CIC456"), 7, 60);
			sistema.agregarEnvio(LocalDate.of(2026, 05, 03), sistema.traerMesa(4, 12), sistema.traerRepartidor("MOT111"), 1, 40);
			sistema.agregarEnvio(LocalDate.of(2026, 04, 29), sistema.traerMesa(5, 20), sistema.traerRepartidor("CIC123"), 3, 8);
			sistema.agregarEnvio(LocalDate.of(2026, 04, 21), sistema.traerMesa(5, 21), sistema.traerRepartidor("CIC456"), 5, 50);
			System.out.println(sistema.getLstEnvios());
		} catch (Exception e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		
		List<Envio> enviosPorFecha = sistema.traerEnviosPorFechaYCosto(LocalDate.of(2026, 05, 02), LocalDate.of(2026, 05, 15), 6000);
		
		System.out.println("\n4) Envios por fechas y costo ---");
		for (Envio e: enviosPorFecha) {
			System.out.println(e.toString());
		}
		
		List<Repartidor> listaEficientes = sistema.traerRepartidoresEficientes();
		
		System.out.println("\n5) Eficientes (Confort) ---");
		for (Repartidor r: listaEficientes) {
			System.out.println(r.toString());
		}
		
		System.out.println("\n6) Exception ---");
		try {
			sistema.agregarRepartidorMoto("MOT111", 2, 200, 85);
		} catch (Exception e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		
		System.out.println("\n7) Exception 2 ---");
		try {
			sistema.agregarEnvio(LocalDate.of(2026, 05, 27), sistema.traerMesa(4, 10), sistema.traerRepartidor("MOT111"), 9, 95);
		} catch (Exception e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		
		System.out.println("\n8) Exception 3 ---");
		try {
			sistema.agregarMesa(4, 10);
		} catch (Exception e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		
	}

}
