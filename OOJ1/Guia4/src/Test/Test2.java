package Test;

import Clases.Fraccion;


public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{ int n=2, d=0;
			System.out.println("-->Escenario 1: new Fraccion("+n+","+d+")");
			Fraccion f1=new Fraccion(n,d);
			System.out.println("Objeto Fraccion: "+f1);
		}
		
		catch ( Exception e ){
		    System.out.println("Excepcion: " + e.getMessage());
		}
		
		
		try{
			int n=3, d=5;
			System.out.println("\n-->Escenario 2: new Fraccion("+n+","+d+")");
			Fraccion f1=new Fraccion(n,d);
			System.out.println("Objeto Fraccion: "+f1);
		}
		
		
		catch ( Exception e ){
		    System.out.println( "Excepcion: " + e.getMessage() );
		}
		
	}

}
