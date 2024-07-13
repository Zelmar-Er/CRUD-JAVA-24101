package ar.com.codo24101.Service;

import ar.com.codo24101.DAO.DirectoresDAO;
import ar.com.codo24101.DAO.GenerosDAO;
import ar.com.codo24101.DAO.PeliculasDAO;
import ar.com.codo24101.DAO.Impl.DirectorJDBCMysqlImpl;
import ar.com.codo24101.DAO.Impl.GeneroJDBCMysqlImpl;
import ar.com.codo24101.DAO.Impl.PeliculasJDBCMysqlImpl;
import ar.com.codo24101.DTO.DirectorDTO;
import ar.com.codo24101.DTO.PeliculasDTO;

public class PeliculaCompletaService {
	private PeliculasDAO daoPeliculas;
	private DirectoresDAO daoDirectores;
	private GenerosDAO daoGeneros;
	
	public PeliculaCompletaService(){
		this.daoPeliculas = new PeliculasJDBCMysqlImpl();
		this.daoDirectores = new DirectorJDBCMysqlImpl();
		this.daoGeneros = new GeneroJDBCMysqlImpl();
	}
	
	public Long obtenerIdDirector(DirectorDTO director) {
		return daoDirectores.getIdDirector(director);
	}
	
	public Long obtenerIdGeneros(String genero) {
		return daoGeneros.getIdGenero(genero);
	}
	
	public void crearPeliculaCompleta(PeliculasDTO pelicula) {
		daoPeliculas.createFullMovi(pelicula);
	}
}
