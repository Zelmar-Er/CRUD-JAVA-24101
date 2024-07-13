package ar.com.codo24101.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ar.com.codo24101.AdminConn.AdminConn;
import ar.com.codo24101.DAO.GenerosDAO;
import ar.com.codo24101.DTO.GeneroDTO;
import ar.com.codo24101.Domain.Genero;

public class GeneroJDBCMysqlImpl implements GenerosDAO{

	@Override
	public void create(GeneroDTO generoDTO) {
		String sql = "INSERT INTO generos (genero) VALUES (?)";
		
		Connection conn = AdminConn.connection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,generoDTO.getGenero());
			statement.executeUpdate();
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			AdminConn.disconnect(conn);
		}
		
	}

	@Override
	public Genero getById(Long id) {
		String sql = "SELECT * FROM generos WHERE id = "+id;
		
		Genero genero = null;
		Connection conn = AdminConn.connection();
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Long gId = resultSet.getLong(1);
				String gGenero = resultSet.getString(2);
				
				genero = new Genero(gId,gGenero);
			}
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			AdminConn.disconnect(conn);
		}
		
		return genero;
	}

	@Override
	public Long getIdGenero(String genero) {
		String sql = "SELECT id FROM generos WHERE genero LIKE '%"+genero+"%'";
		
		Long id = null;
		Connection conn = AdminConn.connection();
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Long Id = resultSet.getLong(1);
				
				id = Id;
			}
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			AdminConn.disconnect(conn);
		}
		
		return id;
	}

	@Override
	public ArrayList<Genero> findAll() {
		String sql = "SELECT * FROM generos";
		
		ArrayList<Genero> generos = new ArrayList<>();
		Connection conn = AdminConn.connection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Long id = resultSet.getLong(1);
				String genero = resultSet.getString(2);
				
				Genero generoData = new Genero(id,genero);
				generos.add(generoData);
			}
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			AdminConn.disconnect(conn);
		}
		return generos;
	}

	
}
