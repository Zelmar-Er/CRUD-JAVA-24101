package ar.com.codo24101.DAO;

import java.util.ArrayList;

import ar.com.codo24101.DTO.GeneroDTO;
import ar.com.codo24101.Domain.Genero;

public interface GenerosDAO {
	
	public void create(GeneroDTO generoDTO);
	public Genero getById(Long id);
	public Long getIdGenero(String genero);
	public ArrayList<Genero> findAll();
}
