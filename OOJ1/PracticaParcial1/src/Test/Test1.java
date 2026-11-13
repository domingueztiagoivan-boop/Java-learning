package Test;

import java.time.LocalDate;
import java.util.List;

import Clases.Cliente;
import Clases.Mesa;
import Clases.Reserva;
import Clases.SistemaRestaurante;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		SistemaRestaurante s1 = new SistemaRestaurante();
		
		try {
			s1.agregarCliente("Juan", "Perez", 38958345, "+541146592131");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			s1.agregarCliente("Mario", "Lopez", 32964234, "+541163927564");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s1.agregarCliente("Delia", "Gonzales", 33095256, "+541109624724");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			s1.agregarMesa(1, 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s1.agregarMesa(2, 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s1.agregarMesa(3, 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s1.agregarMesa(4, 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s1.agregarMesa(5, 6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s1.agregarMesa(6, 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			s1.agregarReserva(s1.traerCliente(38958345), LocalDate.of(2023, 8, 10), s1.traerMesa(3), 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s1.agregarReserva(s1.traerCliente(32964234), LocalDate.of(2023, 8, 10), s1.traerMesa(2), 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s1.agregarReserva(s1.traerCliente(33095256), LocalDate.of(2023, 8, 20), s1.traerMesa(6), 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		List<Reserva> nuevaListaReserva = s1.traerReservasPorFecha(LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 15));
		
		for (Reserva r: nuevaListaReserva) {
			System.out.println("Reserva: " + r.getIdReserva());
		}
		
		List<Mesa> nuevaListaMesas = s1.traerMesasLibresPorFecha(LocalDate.of(2023, 8, 10));
		
		for (Mesa m: nuevaListaMesas) {
			System.out.println("Mesa: " + m.getIdMesa());
		}
		try {
			s1.agregarCliente("Mario", "Lopez", 32964234, "+541163927564");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s1.agregarMesa(2, 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s1.agregarReserva(s1.traerCliente(32964234), LocalDate.of(2023, 8, 10), s1.traerMesa(3), 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			s1.agregarReserva(s1.traerCliente(33095256), LocalDate.of(2023, 8, 15), s1.traerMesa(4), 6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
