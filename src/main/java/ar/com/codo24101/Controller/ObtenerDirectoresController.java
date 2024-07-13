package ar.com.codo24101.Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.Domain.Director;
import ar.com.codo24101.Service.DirectorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ObtenerDirectoresController")
public class ObtenerDirectoresController extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
		DirectorService service = new DirectorService();
		ArrayList<Director> lista = service.ListarDirectores();
		
		ObjectMapper mapper = new ObjectMapper();
		
		String listaJSON = mapper.writeValueAsString(lista);
		
		resp.getWriter().println(listaJSON);
	}
}
