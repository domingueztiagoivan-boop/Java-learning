package Clases;



/// IMPORTANTE: UNA CLASE ENUM NO PUEDE TENER SETERS YA QUE NO SE CAMBIA EL VALOR DE UN ENUM.
/// SE CREAN VARIABLES FINALES CON LOS VALORES QUE SE QUIEREN ASIGNAR A CADA ENUM, Y SE PUEDEN TRAER CON GETTERS.
///CONSTRUCTOR PRIVADO PARA QUE NO SE PUEDA CREAR UN OBJETO DE LA CLASE ENUM FUERA DE ELLA. SOLO SE PUEDEN USAR LOS VALORES DEFINIDOS EN LA CLASE ENUM.
///Usar Genero p == Genero.DRAMA; para asignar el valor del enum a una variable de tipo Genero. No se puede usar new Genero(.


public enum Genero{
	DRAMA(1, "Drama"),
	COMEDIA(2, "Comedia"),
	ACCION(3, "Accion"),
	AVENTURA(4, "Aventura"),
	TERROR(5, "Terror");
	
	private final String genero;
	private final int idGenero;

	Genero(int idGenero, String genero){
		this.idGenero = idGenero;
		this.genero = genero;
	}


	public String getGenero() {
		return this.genero;
	}

	public int getIdGenero() {
		return this.idGenero;
	}
	
	@Override
	public String toString() {
	    // Así, cuando hagas p.getGenero(), Java imprimirá el nombre real
	    return this.genero; 
	}	
	
}
