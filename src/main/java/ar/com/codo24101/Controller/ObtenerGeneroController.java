package ar.com.codo24101.Controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.Domain.Genero;
import ar.com.codo24101.Service.GeneroService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ObtenerGeneroController")
public class ObtenerGeneroController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
		Long idGenero = 1L;
		
		GeneroService service = new GeneroService();
		
		Genero genero = service.obtener(idGenero);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String generoJSON = mapper.writeValueAsString(genero);
		
		resp.getWriter().println(generoJSON);
	}
}
