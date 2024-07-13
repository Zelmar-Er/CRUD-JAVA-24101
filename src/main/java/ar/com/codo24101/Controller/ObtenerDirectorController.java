package ar.com.codo24101.Controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.Domain.Director;
import ar.com.codo24101.Service.DirectorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ObtenerDirectorController")
public class ObtenerDirectorController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
		Long idDirector = 1L;
		
		DirectorService service = new DirectorService();
		
		Director director = service.obtener(idDirector);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String directorJSON = mapper.writeValueAsString(director);
		
		resp.getWriter().println(directorJSON);
	}
}
