package ar.com.codo24101.Controller;

import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.DTO.PeliculasDTO;
import ar.com.codo24101.Service.PeliculasService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/CrearPeliculasController")
public class CrearPeliculasController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
		
		//atrapamos el JSON que viene desde el front
		String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		// pasamos el texto a objeto
		ObjectMapper mapper = new ObjectMapper();
		
		PeliculasDTO pelicula = mapper.readValue(json,PeliculasDTO.class);
		
		PeliculasService service = new PeliculasService();
		
		service.crear(pelicula);
		
		resp.setStatus(HttpServletResponse.SC_CREATED);
	}
}
