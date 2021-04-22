package it.gestionelibreriaweb.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionelibreriaweb.model.Libro;
import it.gestionelibreriaweb.service.MyServiceFactory;
import it.gestionelibreriaweb.utility.UtilityLibroForm;

@WebServlet("/ExecuteInsertLibroServlet")
public class ExecuteInsertLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titoloLibroParameter = request.getParameter("titoloInsert");
		String genereLibroParameter = request.getParameter("genereInsert");
		String pagineLibroParameter = request.getParameter("pagineInsert");
		String dataPubblicazioneLibroParameter = request.getParameter("dataPubblicazioneInsert");

		Date dataPubblicazioneLibroParsed = UtilityLibroForm
				.parseDataPubblicazioneFromString(dataPubblicazioneLibroParameter);
		
		Libro libroEdit = UtilityLibroForm.createBin(titoloLibroParameter, genereLibroParameter, pagineLibroParameter, dataPubblicazioneLibroParameter);

		if (!UtilityLibroForm.validateInput(titoloLibroParameter, genereLibroParameter, pagineLibroParameter,
				dataPubblicazioneLibroParameter) || dataPubblicazioneLibroParsed == null) {
			request.setAttribute("insert_libro_attr", libroEdit);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/libro/insert.jsp").forward(request, response);
			return;
		}

		Libro libroInstance = new Libro(titoloLibroParameter, genereLibroParameter,
				Integer.parseInt(pagineLibroParameter), dataPubblicazioneLibroParsed);

		try {
			MyServiceFactory.getLibroServiceInstance().inserisciNuovo(libroInstance);
			request.setAttribute("listaLibriAttribute", MyServiceFactory.getLibroServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/libro/insert.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/libro/list.jsp").forward(request, response);

	}

}
