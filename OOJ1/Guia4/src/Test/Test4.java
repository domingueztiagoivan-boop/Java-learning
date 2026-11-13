package Test;

import Clases.Producto;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		try {
				Producto p1 = new Producto("Pasta de mani", 15000);
				System.out.println("Creando producto: " + p1.getNombre() + ", precio: " + "$"+p1.getPrecio());
				System.out.println(p1.toString());
				System.out.println("Creado Correctamente.");
		} catch (Exception e) {
			System.out.println("Eception: " + e.getMessage());
			System.out.println("No se pudo crear.");
		}
		
		try {
				Producto p2 = new Producto("Mate cocido", 7500);
				System.out.println("\nCreando producto: " + p2.getNombre() + ", precio: " + "$"+p2.getPrecio());
				System.out.println(p2.toString());
				System.out.println("Creado Correctamente.");
		}	catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			System.out.println("No se pudo crear.");
		}
		
		
		try {	
				Producto p3 = new Producto("Azucar", 0);
				System.out.println("Creando producto: " + p3.getNombre() + ", precio: " + "$"+p3.getPrecio());
				System.out.println(p3.toString());
				System.out.println("Creado Correctamente.");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			System.out.println("No se pudo crear.");
		}
				
				
		
		
	}

}
