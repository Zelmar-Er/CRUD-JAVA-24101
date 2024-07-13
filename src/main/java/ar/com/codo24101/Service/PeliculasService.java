package ar.com.codo24101.Service;

import java.util.ArrayList;

import ar.com.codo24101.DAO.PeliculasDAO;
import ar.com.codo24101.DAO.Impl.PeliculasJDBCMysqlImpl;
import ar.com.codo24101.DTO.PeliculasDTO;
import ar.com.codo24101.Domain.Peliculas;

public class PeliculasService {
	
	private PeliculasDAO dao;
	
	public PeliculasService() {
		this.dao = new PeliculasJDBCMysqlImpl();
	}
	
	public Peliculas obtener(Long id) {
		return this.dao.getById(id);
	}
	
	public void crear(PeliculasDTO peliculasDTO) {
		this.dao.create(peliculasDTO);
	}

	public ArrayList<Peliculas> listarPeliculas() {
		return this.dao.findAll();
	}
	
}
