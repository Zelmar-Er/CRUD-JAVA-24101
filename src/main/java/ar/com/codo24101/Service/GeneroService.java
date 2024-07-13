package ar.com.codo24101.Service;

import java.util.ArrayList;

import ar.com.codo24101.DAO.GenerosDAO;
import ar.com.codo24101.DAO.Impl.GeneroJDBCMysqlImpl;
import ar.com.codo24101.DTO.GeneroDTO;
import ar.com.codo24101.Domain.Genero;

public class GeneroService {
	private GenerosDAO dao;
	
	public GeneroService() {
		this.dao = new GeneroJDBCMysqlImpl();
	}
	
	public void crear(GeneroDTO genero) {
		this.dao.create(genero);
	}
	
	public Genero obtener(Long Id) {
		return this.dao.getById(Id);
	}

	public ArrayList<Genero> listarGeneros() {
		return this.dao.findAll();
	}
}
