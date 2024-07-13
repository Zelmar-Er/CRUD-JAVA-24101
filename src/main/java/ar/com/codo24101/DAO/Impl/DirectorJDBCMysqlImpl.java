package ar.com.codo24101.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ar.com.codo24101.AdminConn.AdminConn;
import ar.com.codo24101.DAO.DirectoresDAO;
import ar.com.codo24101.DTO.DirectorDTO;
import ar.com.codo24101.Domain.Director;

public class DirectorJDBCMysqlImpl implements DirectoresDAO{

	@Override
	public void create(DirectorDTO directorDTO) {
		String sql = "INSERT INTO directores (nombre,apellido) VALUES (?,?)";
		
		Connection conn = AdminConn.connection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,directorDTO.getNombre());
			statement.setString(2,directorDTO.getApellido());
			statement.executeUpdate();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			AdminConn.disconnect(conn);
		}
		
	}

	@Override
	public Director getById(Long id) {
		String sql = "SELECT * FROM directores WHERE id = "+id;
		
		Director director = null;
		Connection conn = AdminConn.connection();
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Long dId = resultSet.getLong(1);
				String dNombre = resultSet.getString(2);
				String dApellido = resultSet.getString(3);
				
				director = new Director(dId,dNombre,dApellido);
			}
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			AdminConn.disconnect(conn);
		}
		
		return director;
	}

	@Override
	public Long getIdDirector(DirectorDTO director) {
		
		String sql = "SELECT id FROM directores WHERE nombre LIKE '%"+director.getNombre()+"%' OR apellido LIKE '%"+director.getApellido()+"%'";
		Long id = null;
		Connection conn = AdminConn.connection();
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				
				 id = resultSet.getLong(1);
				
			}
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			AdminConn.disconnect(conn);
		}
		
		return id;
	}

	@Override
	public ArrayList<Director> findAll() {
		String sql = "SELECT * FROM directores";
		
		ArrayList<Director> directores = new ArrayList<>();
		Connection conn = AdminConn.connection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Long id = resultSet.getLong(1);
				String nombre = resultSet.getString(2);
				String apellido = resultSet.getString(3);
				
				Director director = new Director(id,nombre,apellido);
				directores.add(director);
			}
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			AdminConn.disconnect(conn);
		}
		return directores;
	}

}
