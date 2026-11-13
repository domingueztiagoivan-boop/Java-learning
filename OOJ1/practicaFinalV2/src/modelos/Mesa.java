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


	public boolean equals(Mesa mesa) {
		return (this.numero == mesa.getNumero());
	}
	
	@Override
	public String toString() {
		return "Mesa [id=" + id + ", sector=" + sector + ", numero=" + numero + "]";
	}
	
	
	
	

}
