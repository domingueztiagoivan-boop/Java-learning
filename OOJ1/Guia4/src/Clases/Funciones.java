package Clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Funciones {
	
	
	
		public static boolean esDiaHabil(LocalDate fecha) {   //Funciones static hacen que crear la clase con un constructor previamente no sea necesario. solo con pasar los datos de esa clase basta.
			int d = fecha.getDayOfWeek().getValue();
			
			return ((d>=1) && (d<=5));
		}
		
		
		public static void imprimirVectores(int [] v) {
			System.out.print("\n{");
			for (int e : v) {
				System.out.print(e + " ");
			}
			System.out.print("}");
		}
		
		
		public static double convertirADouble(int n) {
			return ((double)n);
		}
		
		public static boolean esBisiesto(int anio) {
			
			boolean resultado = false;
			
			if ((anio % 4) == 0) {
				
					resultado = true;
					if ((anio % 100) == 0 && (anio % 400) != 0) {
						resultado = false;
				}
			}
			
			return resultado;
		}
		
		public static boolean esFechaValida(LocalDate fecha) {
			
			if (fecha == null) {
				return false;
			}
			
			if (fecha.getMonthValue() == 2 && fecha.getDayOfMonth() == 29) {
				return fecha.isLeapYear();
			}
			
			return true; // java detecta ya de por si si una fecha es o no correcta con el localdate.
		}
		
		
		
		public static String traerFechaCorta(LocalDate fecha) {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return fecha.format(formatter);
		}
		
		
		public static String traerHoraCorta(LocalTime hora) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
			return hora.format(formatter);
		}
		
		public static String traerDiaDeLaSemana(LocalDate fecha) {
			return fecha.getDayOfWeek().toString();
		}
		
		public static String traerMesEnLetras(LocalDate fecha) {
			return fecha.getMonth().toString();
		}
		
		public static int traerCantDiasDeUnMes(int anio, int mes) {
		    int dias = 31; // Por defecto
		    
		    switch (mes) {
		        case 2:
		            // Lógica de bisiesto: divisible por 4 y (no por 100 o sí por 400)
		            dias = ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) ? 29 : 28;
		            break;
		        case 4: case 6: case 9: case 11:
		            dias = 30;
		            break;
		    }
		    return dias;
		}
		
		public static double aproximar2Decimal(double valor) {
		    // Multiplicamos por 100 para que el 3er decimal sea el 1ro después de la coma
		    // Sumamos 0.5 para que si el siguiente es >= 5, redondee hacia arriba al castear
		    return Math.round(valor * 100.0) / 100.0;
		}
		
		
		public static boolean esNumero(char c) {
		    return Character.isDigit(c);
		}
		
		
		public static boolean esLetra(char c) {
		    return Character.isLetter(c);
		}

		
		
		public static boolean esCadenaNros(String cadena) {
		    // "^" inicio, "\\d" dígito, "+" uno o más, "$" fin
		    return cadena.matches("^\\d+$");
		}
		
		
		public static boolean esCadenaLetras(String cadena) {
		    for (int i = 0; i < cadena.length(); i++) {
		        if (!Character.isLetter(cadena.charAt(i))) {
		            return false; // Apenas encuentra algo que no es letra, corta
		        }
		    }
		    return true;
		}
		
		
		public static String traerFechaLarga(LocalDate fecha) {
		    // 1. Definimos los nombres en arreglos (el índice 0 queda vacío para que enero sea 1)
		    String[] dias = {"", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
		    String[] meses = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
		                      "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

		    // 2. Extraemos los valores numéricos de la fecha
		    // getDayOfWeek().getValue() devuelve 1 para Lunes, 7 para Domingo
		    int nroDiaSemana = fecha.getDayOfWeek().getValue(); 
		    int nroDiaMes = fecha.getDayOfMonth();
		    int nroMes = fecha.getMonthValue();
		    int anio = fecha.getYear();

		    // 3. Armamos la cadena concatenando
		    return dias[nroDiaSemana] + " " + nroDiaMes + " de " + meses[nroMes] + " del " + anio;
		}
		    
}
