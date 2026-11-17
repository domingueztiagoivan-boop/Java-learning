package test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Double y Float** \n");

		System.out.println(0.1 + 0.2);

		double total = 0;
		for (int i = 0; i < 10; i++) {
			total += 0.1;
		}
		System.out.println(total);
		System.out.println(total == 1.0);

		/// Resutlados=
		///0.30000000000000004
		///0.9999999999999999
		/// Esto pasa porque double y float no son exactos, ya que se calculan en binario y no en decimal.
		/// Ahora vamos a ver como BigDecimal nos ayuda a resolver este problema.
		

		System.out.println("\n\n\nBigDecimal**\n");

		BigDecimal precio = new BigDecimal("10.50");        // se crea con un String
		BigDecimal otro   = new BigDecimal("2.25");
		BigDecimal suma   = precio.add(otro);                // no se usa +, funciona como un string (parecido, no igual), cada operación devuelve un objeto nuevo y no modifica el original. No se parecen en otra cosa.
		BigDecimal doble  = precio.multiply(new BigDecimal("2"));
		BigDecimal resta = precio.subtract(otro);
		///BigDecimal division = precio.divide(otro); /// divide sin más parámetros exige un resultado exacto; si no lo es, lanza excepción en vez de redondear por su cuenta. (10.50/2.25 NO ES EXACTO)
		BigDecimal division = precio.divide(otro, 2, RoundingMode.HALF_UP);	  /// La Solucion es esta; Cuantos decimales mostrar (2) y como redondea el ultimo decimal representable (RoundingMode.HALF_UP REDONDEA HACIA ARRIBA, POR ESO 6 PASA A 7) 
		BigDecimal division2 = precio.divide(otro, 4, RoundingMode.HALF_UP);

		System.out.println("Precio: " + precio + "\nOtro: " + otro + "\nSuma (Precio + Otro): " + suma + "\nPrecio * 2: " + doble + 
						  "\nResta (Precio - Otro): " + resta + "\nDivision (Precio / Otro 2 decimales): " + division + "\nDivison (Precio / Otro 4 decimales): " + division2);

		System.out.println("\n\nArreglando lo que estaba mal con Double y Float**");

		BigDecimal fix1 = new BigDecimal("0.1").add(new BigDecimal("0.2"));
		BigDecimal fix2 = new BigDecimal("0");

		for (int i = 0; i < 10; i++){
			fix2 = fix2.add(new BigDecimal("0.1"));
		}

		System.out.println("\nFIX 0.1 + 0.2: " + fix1);
		System.out.println("\nFIX 0.1 x 10 == 1: " + fix2);
		///Guarda el número como dígitos decimales exactos, así que no hay error de representación.
		
		///MAS PRUEBAS, COMPARE Y EQUALS.
		BigDecimal a = new BigDecimal("2.0");
		BigDecimal b = new BigDecimal("2.00");
		


		///Compare da un +1 si es mayor, y -1 si es menor
		System.out.println("Resutlado Equals: " + a.equals(b));
		System.out.println("Resultado compare A(2.0) con B(2.00): " + a.compareTo(b)); // da 0 porque es lo mismo
		System.out.println("Resultado compare A(2.0) con 7: "  + a.compareTo(new BigDecimal("7"))); //da -1 porque es menor
		System.out.println("Resultado compare 8 con A(2.0): "  + new BigDecimal("8").compareTo(a)); // da 1 porque es mayor

		///Comprender errores de sintaxis:
		///SIEMPRE SE GUARDA EN UNA NUEVA VARIABLE O EN LA MISMA LLAMANDOSE ASI MISMA CON BIGDECIMAL
		///NO SE GUARDA SINO EL RESULTADO.
		BigDecimal BigDouble = new BigDecimal(0.1);
		System.out.println("BigDecimal sumando un Double: " + BigDouble);
		BigDouble = BigDouble.setScale(2, RoundingMode.HALF_UP);
		System.out.println("BigDecimal sumado un Double con setScale en 2 half_up: " + BigDouble);
		BigDecimal bug2 = precio.add(otro);
		System.out.println("Precio.add con Inmutabilidad (bug sin este): " + bug2);
		BigDecimal division3 = precio.divide(otro, 0, RoundingMode.HALF_UP);
		System.out.println("Division con 0 decimales: " + division3);
		
		///Pruebas con HashSet:
		System.out.println("\n\nHashSet con BigDecimal**");
		Set<BigDecimal> set = new HashSet<>();
		set.add(new BigDecimal("2.0"));
		set.add(new BigDecimal("2.00"));
		System.out.println(set.size()); /// IMPRIME: 2, ya que detecta que 2.0 y 2.00 no son lo mismo.

		/// equals: compara el valor y el scale. Por eso 2.0 y 2.00 dan false.
		///compareTo: compara solo el valor numérico. Por eso dan 0.

		BigDecimal decimales = new BigDecimal("10.50").multiply(new BigDecimal("1.21"));
		System.out.println("Mostrar multiply decimales: " + decimales);
		decimales = decimales.setScale(2, RoundingMode.HALF_UP);
		System.out.println("Mostrar multiply decimales con Scale 2 up: " + decimales);


	}

}
