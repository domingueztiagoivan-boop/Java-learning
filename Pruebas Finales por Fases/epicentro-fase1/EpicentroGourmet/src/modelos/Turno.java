package modelos;



public enum Turno {

	TARDE("Tarde"),
    MANANA("Mañana");

	private final String descripcion;

    Turno(String descripcion) { this.descripcion = descripcion; }

    public String getDescripcion() { return descripcion; }

		
}	

