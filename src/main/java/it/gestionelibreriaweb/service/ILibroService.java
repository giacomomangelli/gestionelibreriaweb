package it.gestionelibreriaweb.service;

import java.util.List;

import it.gestionelibreriaweb.dao.ILibroDao;
import it.gestionelibreriaweb.model.Libro;

public interface ILibroService {

	public void setLibroDao(ILibroDao libroDaoInstance);

	public List<Libro> listAll() throws Exception;

	public Libro caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Libro libroInput) throws Exception;

	public void inserisciNuovo(Libro libroInput) throws Exception;

	public void rimuovi(Libro libroInput) throws Exception;

}
