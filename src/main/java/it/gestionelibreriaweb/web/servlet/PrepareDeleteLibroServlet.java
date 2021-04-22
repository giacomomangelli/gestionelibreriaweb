package it.gestionelibreriaweb.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionelibreriaweb.service.MyServiceFactory;

@WebServlet("/PrepareDeleteLibroServlet")
public class PrepareDeleteLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idLibroParameter = request.getParameter("idLibro");
		
		try {
				request.setAttribute("delete_libro_attr", MyServiceFactory.getLibroServiceInstance()
						.caricaSingoloElemento(Long.parseLong(idLibroParameter)));
				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		
			RequestDispatcher rd = request.getRequestDispatcher("/libro/delete.jsp");
			rd.forward(request, response);
	}	
}
