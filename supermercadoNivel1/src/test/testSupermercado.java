package test;

import clases.Carrito;
import clases.itemCarrito;
import clases.Producto;
import clases.Supermercado;
import java.time.LocalDate;
import java.time.LocalTime;


public class testSupermercado {

	public static void main(String[] args) {
	
		
		Supermercado super1 = new Supermercado();
		
		super1.agregarPoducto("Pan", 2150);
		super1.agregarPoducto("Almendras", 4500);
		super1.agregarPoducto("Pistacho", 15000);
		super1.agregarPoducto("Agua", 1500);
		super1.agregarPoducto("Oreos", 3500);
		super1.agregarPoducto("Tortas", 11000);
		
		
		System.out.println("Cantidad en gondola: " + super1.getGondola().size());
		
		Producto p1 = super1.traerProducto(1);
		Producto p2 = super1.traerProducto(2);
		Producto p3 = super1.traerProducto(3);
		Producto p4 = super1.traerProducto(4);
		Producto p5 = super1.traerProducto(5);
		
		System.out.print(p1.toString());
		super1.modificarProducto(2, "Pepas", 700);
		System.out.print(p1.toString());
		super1.eliminarProducto(2);
		System.out.println("Cantidad en gondola: " + super1.getGondola().size());
		
		LocalDate fechaHoy = LocalDate.now();
		LocalTime horaAhora = LocalTime.now();
		
		Carrito carrito1 = new Carrito(fechaHoy, horaAhora);
		carrito1.agregarItem(p1,  1);
		carrito1.agregarItem(p2,  2);
		carrito1.agregarItem(p3,  3);
		carrito1.agregarItem(p4,  4);
		carrito1.agregarItem(p5,  5);

		System.out.print("\n\n" + carrito1.getLstCarrito().size());
		
		carrito1.eliminarItem(p5, 5); //lo saca porque son 5 cantidades
		System.out.print("\n\n" + carrito1.getLstCarrito().size());
		
		float subtotal = carrito1.calcularSubTotal();
		float total = carrito1.calcularTotal();
		
		System.out.print("\nSubtotal: " + subtotal);
		System.out.print("\nSubtotal: " + total); //iva
		
		
		
	}

}
