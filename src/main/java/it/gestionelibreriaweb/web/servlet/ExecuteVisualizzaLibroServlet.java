package it.gestionelibreriaweb.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.gestionelibreriaweb.service.MyServiceFactory;


@WebServlet("/ExecuteVisualizzaLibroServlet")
public class ExecuteVisualizzaLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idLibroParameter = request.getParameter("idLibro");

		if (!NumberUtils.isCreatable(idLibroParameter)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("visualizza_libro_attr", MyServiceFactory.getLibroServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idLibroParameter)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/libro/show.jsp").forward(request, response);
	}

}
