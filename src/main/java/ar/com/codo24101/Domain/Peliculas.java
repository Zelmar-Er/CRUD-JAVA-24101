package ar.com.codo24101.Domain;

public class Peliculas {
	private Long id;
	private String titulo;
	private String imagen;
	private Long director;
	private Long genero;
	
	public Peliculas (Long id,String titulo,String imagen,Long director, Long genero) {
		this.setId(id);
		this.setTitulo(titulo);
		this.setImagen(imagen);
		this.setDirector(director);
		this.setGenero(genero);
	}
	
	public Peliculas (String titulo,String imagen,Long director,Long genero) {
		this.setTitulo(titulo);
		this.setImagen(imagen);
		this.setDirector(director);
		this.setGenero(genero);
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

	public void setTitulo(String titulo) {
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
		return "Peliculas [id=" + id + ", titulo=" + titulo + ", imagen=" + imagen + ", director=" + director
				+ ", genero=" + genero + "]";
	}
	
}
