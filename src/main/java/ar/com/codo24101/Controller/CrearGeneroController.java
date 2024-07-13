package ar.com.codo24101.Controller;


import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.DTO.GeneroDTO;
import ar.com.codo24101.Service.GeneroService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/CrearGeneroController")
public class CrearGeneroController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
	
		//atrapamos el JSON que viene desde el front
		String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	
		// pasamos el texto a objeto
		ObjectMapper mapper = new ObjectMapper();
		
		GeneroDTO genero = mapper.readValue(json,GeneroDTO.class);
		
		GeneroService service = new GeneroService();
		
		service.crear(genero);
		
		resp.setStatus(HttpServletResponse.SC_CREATED);
	}
}
