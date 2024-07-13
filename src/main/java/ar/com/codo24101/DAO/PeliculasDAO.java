package ar.com.codo24101.DAO;

import java.util.ArrayList;

import ar.com.codo24101.DTO.PeliculasDTO;
import ar.com.codo24101.Domain.Peliculas;

public interface PeliculasDAO {
	
	public void create(PeliculasDTO peliculasDTO);
	public Peliculas getById(Long id);
	public void createFullMovi(PeliculasDTO pelicula);
	public ArrayList<Peliculas> findAll();
}
