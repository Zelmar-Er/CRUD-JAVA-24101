package ar.com.codo24101.Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.Domain.Genero;
import ar.com.codo24101.Service.GeneroService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ObtenerGenerosController")
public class ObtenerGenerosController extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
		GeneroService service = new GeneroService();
		ArrayList<Genero> lista = service.listarGeneros();
		
		ObjectMapper mapper = new ObjectMapper();
		
		String listaJSON = mapper.writeValueAsString(lista);
		
		resp.getWriter().println(listaJSON); 
	}

}
