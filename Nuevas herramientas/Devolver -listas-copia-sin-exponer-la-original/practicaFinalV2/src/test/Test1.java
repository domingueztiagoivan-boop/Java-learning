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
		} catch (ExceptionYaRegistrado e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			sistema.agregarRepartidorMoto("MOT111", 2, 300, 95);
			sistema.agregarRepartidorMoto("MOT222", 5, 550, 130);
			sistema.agregarRepartidorCiclista("CIC123", 4, false, 2000);
			sistema.agregarRepartidorCiclista("CIC456", 8, true, 3500);
			System.out.println(sistema.getLstRepartidores());
		} catch (ExceptionYaRegistrado e) {
			System.out.println(e.getMessage());
		}
		catch (ExceptionRepartidorMenorCero e) {
			System.out.println(e.getMessage());
		}
		
		



		try {
			sistema.agregarEnvio(LocalDate.of(2026, 05, 15), sistema.traerMesa(4, 10), sistema.traerRepartidor("MOT222"), 4, 25);
			sistema.agregarEnvio(LocalDate.of(2026, 05, 12), sistema.traerMesa(4, 11), sistema.traerRepartidor("CIC456"), 7, 60);
			sistema.agregarEnvio(LocalDate.of(2026, 05, 03), sistema.traerMesa(4, 12), sistema.traerRepartidor("MOT111"), 1, 40);
			sistema.agregarEnvio(LocalDate.of(2026, 04, 29), sistema.traerMesa(5, 20), sistema.traerRepartidor("CIC123"), 3, 8);
			sistema.agregarEnvio(LocalDate.of(2026, 04, 21), sistema.traerMesa(5, 21), sistema.traerRepartidor("CIC456"), 5, 50);
			System.out.println(sistema.getLstEnvios());
		} catch (ExceptionRepartidor e) {
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
		} catch (ExceptionYaRegistrado e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		catch (ExceptionRepartidorMenorCero e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		
		System.out.println("\n7) Exception 2 ---");
		try {
			sistema.agregarEnvio(LocalDate.of(2026, 05, 27), sistema.traerMesa(4, 10), sistema.traerRepartidor("MOT111"), 9, 95);
		} catch (ExceptionRepartidor e) {
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
			sistema.agregarEnvio(LocalDate.of(2026, 05, 27), sistema.traerMesa(9, 19), sistema.traerRepartidor("MOT111"), 9, 95);
		} catch (ExceptionRepartidor e) {
			System.out.println("Exception capturada: " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("Null capturado: " + e.getMessage());
		}


		///SI UN GET NO DEVUELVE UNA COPIA, SE PUEDE ROMPER LA LISTA ORIGINAL. INCLUSO CON GET DEVOLVIENDO UNA COPIA SE PUEDE ROMPER, AHORA LA PRUEBA.
		///Lo dejo comentado para que no tire la exception(correctamente ya que no deberia poder tirar un clear(), ya que esta protegida por Lista.copyOf()
		
		///System.out.println("\n10) Rompiendo una lista con get ---");
		///List<Mesa> listaMesas = sistema.getLstMesas();
		///System.out.println("Lista original: " + sistema.getLstMesas());
		///listaMesas.clear();
		///System.out.println("Lista modificada: " + listaMesas);

		///System.out.println("\n\nPROBANDO CON SET Y GET QUE DEVUELVE UNA COPIA ---");
		
		///Mesa m = sistema.getLstMesas().get(0);   // ¿es una copia de la Mesa o la Mesa real? Es la mesa real, ya que al ser una copia que devuelve el get, tambien devuelve el ojeto real.
		///m.setNumero(999); ///Tomamos el primero de la lista original y lo modificamos con un set. 
		///System.out.println(sistema.getLstMesas());

		///[Mesa [id=1, sector=4, numero=999] Acabamos de modificar la lista original, apesar de nos da una copia el get. 
		///El motivo pasa ya que aunque hacemos una copia, tenemos los mismos objetos dentro de la lista copia.
		///Y si modificamos un objeto de la lista copia, estamos modificando el mismo objeto que esta en la lista original.
		///Para evitar esto, deberiamos hacer un deep copy, es decir, devolver una copia de la lista y de los objetos que contiene. (mas adelante)
		
	}

}
