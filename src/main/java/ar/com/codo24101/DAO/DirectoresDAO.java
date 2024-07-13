package ar.com.codo24101.DAO;

import java.util.ArrayList;

import ar.com.codo24101.DTO.DirectorDTO;
import ar.com.codo24101.Domain.Director;

public interface DirectoresDAO {
	
	public void create(DirectorDTO directorDTO);
	public Director getById(Long id);
	public Long getIdDirector(DirectorDTO director);
	public ArrayList<Director> findAll();
}
