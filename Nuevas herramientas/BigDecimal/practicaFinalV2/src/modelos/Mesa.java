package modelos;

public class Mesa {
	private final int id;
	private int sector;
	private final int numero;
	
	
	public Mesa(int id, int sector, int numero) {
		this.id = id;
		this.sector = sector;
		this.numero = numero;
	}


	/// ELIMINAMOS LOS SET QUE NO QUEREMOS QUE CAMBIEN DATOS IMPORTANTES; COMO ID y NUMERO.

	public int getId() {
		return id;
	}
	
	public int getSector() {
		return sector;
	}
	public void setSector(int sector) {
		this.sector = sector;
	}
	public int getNumero() {
		return numero;
	}
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Mesa)) return false;
		Mesa other = (Mesa) obj;
		return this.sector == other.getSector() && this.numero == other.getNumero();
	}

	@Override
	public int hashCode(){
		return Integer.hashCode(sector) + Integer.hashCode(numero);
	}
	
	@Override
	public String toString() {
		return "Mesa [id=" + id + ", sector=" + sector + ", numero=" + numero + "]";
	}
	
	
	
	

}
