package Test;

import Clases.Fraccion;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
				Fraccion f2=new Fraccion(2,5);
				Fraccion f3=new Fraccion(0,3);
				System.out.println("-->Escenario 1: Dividir "+f2+" por "+f3);
				System.out.println(f2+"/"+f3+"="+f2.dividir(f3));
			}
			catch ( Exception e ){
				System.out.println("Excepcion: " + e.getMessage());
			}
		
		
			try{
				Fraccion f2=new Fraccion(2,5);
				Fraccion f3=new Fraccion(7,3);
				System.out.println("\n-->Escenario 2: Dividir "+f2+ " por "+f3);
				System.out.println(f2+"/"+f3+"="+f2.dividir(f3));
			}
			catch ( Exception e ){
				System.out.println("Excepcion: " + e.getMessage());
			}
		
	}

}
