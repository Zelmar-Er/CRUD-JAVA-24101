package ar.com.codo24101.DTO;

public class GeneroDTO {
	private Long id;
	private String genero;
	
	public GeneroDTO() {
		
	}	
	public GeneroDTO(Long id,String genero) {
		this.id = id;
		this.genero = genero;
	}
	public GeneroDTO(String genero) {
		this.genero = genero;
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
}
