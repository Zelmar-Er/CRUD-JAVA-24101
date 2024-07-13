package ar.com.codo24101.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ar.com.codo24101.AdminConn.AdminConn;
import ar.com.codo24101.DAO.PeliculasDAO;
import ar.com.codo24101.DTO.PeliculasDTO;
import ar.com.codo24101.Domain.Peliculas;

public class PeliculasJDBCMysqlImpl implements PeliculasDAO{

	@Override
	public void create(PeliculasDTO peliculasDTO) {
		String sql = "INSERT INTO peliculas (titulo,imagen) VALUES (?,?)";
		
		Connection conn = AdminConn.connection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,peliculasDTO.getTitulo());
			statement.setString(2,peliculasDTO.getImagen());
			statement.executeUpdate();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			AdminConn.disconnect(conn);
		}
	}

	@Override
	public Peliculas getById(Long id) {
		String sql = "SELECT * FROM peliculas WHERE id = "+id;
		
		Peliculas peliculas = null;
		Connection conn = AdminConn.connection();
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Long pId = resultSet.getLong(1);
				String pTitulo = resultSet.getString(2);
				String pImagen = resultSet.getString(3);
				Long pDirector = resultSet.getLong(4);
				Long pGenero = resultSet.getLong(5);
				
				peliculas = new Peliculas(pId,pTitulo,pImagen,pDirector,pGenero);
			}
		}catch(Exception e) {
			System.err.println(e);
		}finally{
			AdminConn.disconnect(conn);
		}
		
		return peliculas;
	}

	@Override
	public void createFullMovi(PeliculasDTO pelicula) {
		String sql = "INSERT INTO peliculas (titulo,imagen,director,genero) VALUES (?,?,?,?)";
		
		Connection conn = AdminConn.connection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,pelicula.getTitulo());
			statement.setString(2,pelicula.getImagen());
			statement.setLong(3,pelicula.getDirector());
			statement.setLong(4,pelicula.getGenero());
			statement.executeUpdate();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			AdminConn.disconnect(conn);
		}
	}

	@Override
	public ArrayList<Peliculas> findAll() {
		String sql = "SELECT * FROM peliculas";
		
		ArrayList<Peliculas> peliculas = new ArrayList<>();
		Connection conn = AdminConn.connection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Long id = resultSet.getLong(1);
				String titulo = resultSet.getString(2);
				String imagen = resultSet.getString(3);
				Long directorId = resultSet.getLong(4);
				Long generoId = resultSet.getLong(5);
				
				Peliculas pelicula= new Peliculas(id,titulo,imagen,directorId,generoId);
				peliculas.add(pelicula);
			}
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			AdminConn.disconnect(conn);
		}
		return peliculas;
	}

}
