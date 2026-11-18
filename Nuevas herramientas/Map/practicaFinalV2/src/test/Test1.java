package test;

import java.math.BigDecimal;
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
			System.out.println(sistema.getMesasMap().toString());
		} catch (ExceptionYaRegistrado e) {
			System.out.println(e.getMessage());
		}
	
		
		
		try {
			sistema.agregarRepartidorMoto("MOT111", 2, new BigDecimal("300"), new BigDecimal("95"));
			sistema.agregarRepartidorMoto("MOT222", 5, new BigDecimal("550"), new BigDecimal("130"));
			sistema.agregarRepartidorCiclista("CIC123", 4, false, new BigDecimal("2000"));
			sistema.agregarRepartidorCiclista("CIC456", 8, true, new BigDecimal("3500"));
			System.out.println(sistema.getRepartidoresMap().toString());
		} catch (ExceptionYaRegistrado e) {
			System.out.println(e.getMessage());
		}
		catch (ExceptionRepartidorMenorCero e) {
			System.out.println(e.getMessage());
		}

		
		



		try {
			sistema.agregarEnvio(LocalDate.of(2026, 05, 15), sistema.traerMesa(4, 10), sistema.traerRepartidor("MOT222"), 4, new BigDecimal("25"));
			sistema.agregarEnvio(LocalDate.of(2026, 05, 12), sistema.traerMesa(4, 11), sistema.traerRepartidor("CIC456"), 7, new BigDecimal("60"));
			sistema.agregarEnvio(LocalDate.of(2026, 05, 03), sistema.traerMesa(4, 12), sistema.traerRepartidor("MOT111"), 1, new BigDecimal("40"));
			sistema.agregarEnvio(LocalDate.of(2026, 04, 29), sistema.traerMesa(5, 20), sistema.traerRepartidor("CIC123"), 3, new BigDecimal("8"));
			sistema.agregarEnvio(LocalDate.of(2026, 04, 21), sistema.traerMesa(5, 21), sistema.traerRepartidor("CIC456"), 5, new BigDecimal("50"));
			System.out.println(sistema.getEnviosMap().toString());
		} catch (ExceptionRepartidor e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		catch (ExceptionSinRegistrar e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		
	
		List<Envio> enviosPorFecha = sistema.traerEnviosPorFechaYCosto(LocalDate.of(2026, 05, 02), LocalDate.of(2026, 05, 15), new BigDecimal("6000"));
		
		
		
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
			sistema.agregarRepartidorMoto("MOT111", 2, new BigDecimal("200"), new BigDecimal("85"));
		} catch (ExceptionYaRegistrado e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		catch (ExceptionRepartidorMenorCero e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}

		
		System.out.println("\n7) Exception 2 ---");
		try {
			sistema.agregarEnvio(LocalDate.of(2026, 05, 27), sistema.traerMesa(4, 10), sistema.traerRepartidor("MOT111"), 9, new BigDecimal("95"));
		} catch (ExceptionRepartidor e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		catch (ExceptionSinRegistrar e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		
		System.out.println("\n8) Exception 3 ---");
		try {
			sistema.agregarMesa(4, 10);
		} catch (ExceptionYaRegistrado e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}

		System.out.println("\n9) Exception 4 ---");
		try {
			sistema.agregarEnvio(LocalDate.of(2026, 05, 27), sistema.traerMesa(9, 19), sistema.traerRepartidor("MOT111"), 9, new BigDecimal("95"));
		} catch (ExceptionRepartidor e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("Null capturado: " + e.getMessage());
		}
		catch (ExceptionSinRegistrar e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		
		System.out.println("\n10) Exception 5 ---");
		try {
			sistema.cambiarRepartidorCapacidadPedidosMax("MOT222", 2);
		} catch (ExceptionRepartidor e) {
			System.out.println(e.getMessage());
		}
		catch (ExceptionRepartidorMenorCero e) {
			System.out.println(e.getMessage());
		}
		catch (ExceptionSinRegistrar e) {
			System.out.println(e.getMessage());
		}



		System.out.println("\n11) Exception 6 ---");
		try {
		sistema.agregarEnvio(LocalDate.of(2026, 10, 25), sistema.traerMesa(4, 10), sistema.traerRepartidor("MOT222"), 9, new BigDecimal("25"));
		} catch (ExceptionRepartidor e){
			System.out.println(e.getMessage());
		}
		catch (ExceptionSinRegistrar e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}

	}
	/// MAPS NO ORIDENA LA LISTAS.
}
