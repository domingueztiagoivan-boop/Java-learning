package Test;

import Clases.Cliente;
import Clases.Reserva;

import java.time.LocalDate;
import java.util.List;

import Clases.Cancha;
import Clases.SistemaAlquiler;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SistemaAlquiler s1 = new SistemaAlquiler();
		
		try {
			s1.agregarCliente("Pepe", "Pelegrino", "+5401126789014", 19876153);
			s1.agregarCliente("Jorge", "Galtran", "+5401190246718", 25678912);
			s1.agregarCliente("Tito", "Gonzales", "+5401178239012", 40876523);
			s1.agregarCliente("Pedro", "Diego", "+5401189765522", 30895123);
			s1.agregarCliente("Lamine", "Lewandoski", "+5401126789014", 19876153); // da mal
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			s1.agregarCancha(12, 1);
			s1.agregarCancha(16, 2);
			s1.agregarCancha(16, 3);
			s1.agregarCancha(12, 4);
			s1.agregarCancha(12, 1);// da mal
		} catch(Exception e) {
			System.out.println(e.getMessage());			
		}
		
		try {
			s1.agregarReserva(s1.traerCliente(19876153), s1.traerCancha(1), LocalDate.of(2026, 5, 10), 10);
			s1.agregarReserva(s1.traerCliente(25678912), s1.traerCancha(2), LocalDate.of(2026, 5, 8), 16);
			s1.agregarReserva(s1.traerCliente(40876523), s1.traerCancha(3), LocalDate.of(2026, 5, 15), 14);
			s1.agregarReserva(s1.traerCliente(19876153), s1.traerCancha(1), LocalDate.of(2026, 5, 11), 10);
			s1.agregarReserva(s1.traerCliente(40876523), s1.traerCancha(2), LocalDate.of(2026, 5, 10), 12);
			s1.agregarReserva(s1.traerCliente(30895123), s1.traerCancha(4), LocalDate.of(2026, 5, 10), 18); //da mal
		} catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		
		
		
		List<Cancha> nuevaListaCancha = s1.traerCanchasLibresPorFecha(LocalDate.of(2026, 5, 10));
		
		for (Cancha c: nuevaListaCancha) {
			System.out.println(c.toString());
		}
		
		List<Reserva> nuevaListaReserva = s1.traerReservasPorFecha(LocalDate.of(2026, 5, 10), LocalDate.of(2026, 5, 15));
		
		for(Reserva r: nuevaListaReserva) {
			System.out.println(r.toString());
		}
		
		System.out.print("\n\n");
		
		for(Cliente c: s1.getLstClientes()) {
			System.out.println(c.toString());
		}
		
		for (Cancha c: s1.getLstCanchas()) {
			System.out.println(c.toString());
		}
		
		for (Reserva r: s1.getLstReservas()) {
			System.out.println(r.toString());
		}
	}

}
