package ar.com.codo24101.Service;

import java.util.ArrayList;

import ar.com.codo24101.DAO.DirectoresDAO;
import ar.com.codo24101.DAO.Impl.DirectorJDBCMysqlImpl;
import ar.com.codo24101.DTO.DirectorDTO;
import ar.com.codo24101.Domain.Director;

public class DirectorService {
	private DirectoresDAO dao;
	
	public DirectorService() {
		this.dao = new DirectorJDBCMysqlImpl();
	}
	
	public Director obtener(Long id) {
		return this.dao.getById(id);
	}
	
	public void crear(DirectorDTO director) {
		dao.create(director);
	}
	
	public ArrayList<Director> ListarDirectores() {
		return this.dao.findAll();
	}
}
