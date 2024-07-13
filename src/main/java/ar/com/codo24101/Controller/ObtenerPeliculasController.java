package ar.com.codo24101.Controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.Domain.Peliculas;
import ar.com.codo24101.Service.PeliculasService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ObtenerPeliculasController")
public class ObtenerPeliculasController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
		Long idPelicula = 1L;
		
		PeliculasService service = new PeliculasService();
		
		Peliculas pelicula = service.obtener(idPelicula);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String peliculaJSON = mapper.writeValueAsString(pelicula);
		
		resp.getWriter().println(peliculaJSON);
	}
}
