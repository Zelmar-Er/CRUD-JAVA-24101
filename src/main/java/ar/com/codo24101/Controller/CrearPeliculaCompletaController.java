package ar.com.codo24101.Controller;

import ar.com.codo24101.DTO.DirectorDTO;
import ar.com.codo24101.DTO.PeliculasDTO;
import ar.com.codo24101.Service.PeliculaCompletaService;

// Sin implementar en servlet
public class CrearPeliculaCompletaController {
	public static void main(String[]args) {
		Long genero;
		Long director;
		DirectorDTO directorDto = new DirectorDTO("Zelmar","Pumputis");
		
		PeliculaCompletaService peliculaCompleta = new PeliculaCompletaService();
		
		director = peliculaCompleta.obtenerIdDirector(directorDto);
		genero = peliculaCompleta.obtenerIdGeneros("Drama");
		System.out.println(director);
		PeliculasDTO pelicula = new PeliculasDTO("Completa5","imgC",director,genero);
		
		
		
		peliculaCompleta.crearPeliculaCompleta(pelicula);
		
	}
}
