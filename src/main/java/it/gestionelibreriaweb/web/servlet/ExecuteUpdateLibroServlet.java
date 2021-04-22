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
import it.gestionelibreriaweb.utility.UtilityLibroForm;

@WebServlet("/ExecuteUpdateLibroServlet")
public class ExecuteUpdateLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String libroIdParameter = request.getParameter("idLibroEdit");
		String titoloLibroEditParameter = request.getParameter("titoloEdit");
		String genereLibroEditParameter = request.getParameter("genereEdit");
		String pagineLibroEditParameter = request.getParameter("pagineEdit");
		String dataLibroEditParameter = request.getParameter("dataPubblicazioneEdit");
		
		Libro libroEdit = UtilityLibroForm.createBin(titoloLibroEditParameter, genereLibroEditParameter, pagineLibroEditParameter, dataLibroEditParameter);
		
		if (!UtilityLibroForm.validateInput(titoloLibroEditParameter, genereLibroEditParameter,
				pagineLibroEditParameter, dataLibroEditParameter) || dataLibroEditParameter == null) {

			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.setAttribute("update_libro_attr", libroEdit);
			request.getRequestDispatcher("/libro/update.jsp").forward(request, response);
			return;
		}
		
		try {
			
			ILibroService libroService = MyServiceFactory.getLibroServiceInstance();
			Libro libro = libroService.caricaSingoloElemento(Long.parseLong(libroIdParameter));
			
			libro.setTitolo(libroEdit.getTitolo());
			libro.setGenere(libroEdit.getGenere());
			libro.setDataDiPubblicazione(libroEdit.getDataDiPubblicazione());
			libro.setPagine(libroEdit.getPagine());
			
			libroService.aggiorna(libro);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
	}		
}
