package modelos;

public class Mesa {
	private int id;
	private int sector;
	private int numero;
	
	
	public Mesa(int id, int sector, int numero) {
		this.id = id;
		this.sector = sector;
		this.numero = numero;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setNumero(int numero) {
		this.numero = numero;
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
