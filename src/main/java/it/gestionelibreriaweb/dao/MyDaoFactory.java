package it.gestionelibreriaweb.dao;

public class MyDaoFactory {

	private static ILibroDao libroDaoInstance = null;

	public static ILibroDao getLibroDaoInstance() {
		if (libroDaoInstance == null) {
			libroDaoInstance = new LibroDaoImpl();
		}
		return libroDaoInstance;
	}
}
