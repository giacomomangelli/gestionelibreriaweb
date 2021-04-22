package it.gestionelibreriaweb.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.gestionelibreriaweb.dao.ILibroDao;
import it.gestionelibreriaweb.model.Libro;
import it.gestionelibreriaweb.web.listener.LocalEntityManagerFactoryListener;

public class LibroServiceImpl implements ILibroService {

	private ILibroDao libroDaoInstance;

	@Override
	public void setLibroDao(ILibroDao libroDaoInstance) {
		this.libroDaoInstance = libroDaoInstance;
	}

	@Override
	public List<Libro> listAll() throws Exception {

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			libroDaoInstance.setEntityManager(entityManager);
			return libroDaoInstance.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}
	}

	@Override
	public Libro caricaSingoloElemento(Long idInput) throws Exception {
		
		if(idInput < 1 || idInput == null) {
			throw new Exception("Errore inserimento idInput service per caricare l'elemento.");
		}

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			libroDaoInstance.setEntityManager(entityManager);
			return libroDaoInstance.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}

	}

	@Override
	public void aggiorna(Libro libroInput) throws Exception {

		if(libroInput == null) {
			throw new Exception("Errore inserimento libroInput service per aggiornare l'elemento.");
		}
		
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			libroDaoInstance.setEntityManager(entityManager);
			libroDaoInstance.update(libroInput);

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}
	}

	@Override
	public void inserisciNuovo(Libro libroInput) throws Exception {
		
		if(libroInput == null) {
			throw new Exception("Errore inserimento libroInput service per inserire nuovo elemento.");
		}
		
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			libroDaoInstance.setEntityManager(entityManager);
			libroDaoInstance.insert(libroInput);

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}
	}

	@Override
	public void rimuovi(Libro libroInput) throws Exception {
		
		if(libroInput == null) {
			throw new Exception("Errore inserimento libroInput service per rimuovere l'elemento.");
		}
		
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			libroDaoInstance.setEntityManager(entityManager);
			entityManager.merge(libroInput);
			libroDaoInstance.delete(libroInput);

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;

		} finally {
			entityManager.close();
		}
	}
}
