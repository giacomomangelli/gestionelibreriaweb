package it.gestionelibreriaweb.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionelibreriaweb.model.Libro;

@WebServlet("/PrepareInsertLibroServlet")
public class PrepareInsertLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Libro libro = new Libro();
		
		request.setAttribute("insert_libro_attr", libro);

		request.getRequestDispatcher("/libro/insert.jsp").forward(request, response);

	}
}
