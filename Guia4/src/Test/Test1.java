package Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import Clases.Funciones;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LocalDate fechaActual = LocalDate.now();
		LocalTime horaActual = LocalTime.now();
		LocalDate date = LocalDate.of(2027, 5, 29);
		LocalDate date2 = date.minusMonths(2);
		LocalDate date3 = date.minusYears(10);
		
		System.out.print("\n" + fechaActual + "  Hora: " + horaActual);
		System.out.print("\n" + "Barsa Campeon champions: " + date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
		System.out.print("\n" + horaActual.getHour()+ ":" + horaActual.getMinute() + ":" +horaActual.getSecond());
		System.out.print("\n" + date2);
		System.out.print("\n" + date3);
		System.out.print("\nLa primera fecha es menor que la segunda?: " + date.isBefore(date2));
		System.out.print("\nY la segunda fecha es mayor que la tercera?: " + date2.isAfter(date3));
		
		System.out.print("\nEs dia habil el 5/5/2026?: " + Funciones.esDiaHabil(LocalDate.of(2026, 5, 5)));	
		
		
		int a []={1, 2, 3, 6, 3, 7, 2};
		Funciones.imprimirVectores(a);
		
		System.out.print("\n" + Funciones.esBisiesto(1900));
		System.out.print("\n" + Funciones.esBisiesto(2004));
		System.out.print("\n" + Funciones.esFechaValida(LocalDate.of(2004, 02, 29)));
		System.out.print("\n" + Funciones.traerFechaCorta(fechaActual));
		System.out.print("\n" + Funciones.traerHoraCorta(horaActual));
		System.out.print("\n" + Funciones.traerDiaDeLaSemana(fechaActual));
		System.out.print("\n" + Funciones.traerMesEnLetras(fechaActual));
		
		

	}

}
