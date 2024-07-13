package ar.com.codo24101.Controller;

import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.DTO.DirectorDTO;
import ar.com.codo24101.Service.DirectorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CrearDirectorController")
public class CrearDirectorController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
		
		//atrapamos el JSON que viene desde el front
		String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		// pasamos el texto a objeto
		ObjectMapper mapper = new ObjectMapper();
		
		DirectorDTO director = mapper.readValue(json,DirectorDTO.class);
		
		DirectorService service = new DirectorService();
		
		service.crear(director);
		
		resp.setStatus(HttpServletResponse.SC_CREATED);
	}
}
