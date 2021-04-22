package it.gestionelibreriaweb.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionelibreriaweb.model.Libro;
import it.gestionelibreriaweb.service.ILibroService;
import it.gestionelibreriaweb.service.MyServiceFactory;


@WebServlet("/ExecuteDeleteLibroServlet")
public class ExecuteDeleteLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String libroIdParameter = request.getParameter("idLibro");

		try {
			
			ILibroService libroService = MyServiceFactory.getLibroServiceInstance();
			Libro libro = libroService.caricaSingoloElemento(Long.parseLong(libroIdParameter));
			libroService.rimuovi(libro);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
	}
}