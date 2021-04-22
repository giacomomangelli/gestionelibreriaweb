package it.gestionelibreriaweb.service;

import it.gestionelibreriaweb.dao.ILibroDao;
import it.gestionelibreriaweb.dao.LibroDaoImpl;

public class MyServiceFactory {

	private static ILibroService libroServiceInstance = null;
	private static ILibroDao libroDaoInstance = null;

	public static ILibroService getLibroServiceInstance() {
		if (libroServiceInstance == null)
			libroServiceInstance = new LibroServiceImpl();

		if (libroDaoInstance == null)
			libroDaoInstance = new LibroDaoImpl();

		libroServiceInstance.setLibroDao(libroDaoInstance);

		return libroServiceInstance;
	}

}
