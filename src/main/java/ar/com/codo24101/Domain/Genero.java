package ar.com.codo24101.Domain;

public class Genero {
	private Long id;
	private String genero;
	
	public Genero(Long id,String genero) {
		this.setId(id);
		this.setGenero(genero);
	}
	
	public Genero(String genero) {
		this.setGenero(genero);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Genero [id=" + id + ", genero=" + genero + "]";
	}
	
	
}
