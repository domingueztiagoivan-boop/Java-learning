package modelos;



public enum Temporada {

	VERANO("Verano"),
    PRIMAVERA("Primavera"),
    OTONO("Otoño"),
    INVIERNO("Invierno");

	private final String descripcion;

    Temporada(String descripcion) { this.descripcion = descripcion; }

    public String getDescripcion() { return descripcion; }

		
}	

