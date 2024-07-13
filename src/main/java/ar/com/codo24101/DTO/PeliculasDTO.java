package ar.com.codo24101.DTO;

public class PeliculasDTO {
	private Long id;
	private String titulo;
	private String imagen;
	private Long director;
	private Long genero;
	
	public PeliculasDTO() {
		
	}
	public PeliculasDTO(Long id, String titulo, String imagen) {
		this.id = id;
		this.titulo = titulo;
		this.imagen = imagen;
	}
	public PeliculasDTO(String titulo, String imagen) {
		this.titulo = titulo;
		this.imagen = imagen;
	}
	public PeliculasDTO(String titulo, String imagen, Long director,Long genero) {
		this.titulo = titulo;
		this.imagen = imagen;
		this.director = director;
		this.genero = genero;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTituto(String titulo) {
		this.titulo = titulo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public Long getDirector() {
		return director;
	}
	
	public void setDirector(Long director) {
		this.director = director;
	}
	
	public Long getGenero() {
		return genero;
	}
	
	public void setGenero(Long genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "PeliculasDTO [id=" + id + ", titulo=" + titulo + ", imagen=" + imagen + ", director=" + director
				+ ", genero=" + genero + "]";
	}
	
}
